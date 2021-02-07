package com.zwy.blog.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zwy.blog.common.utils.JwtTokenUtil;
import com.zwy.blog.dao.BlAdminRoleRelationDao;
import com.zwy.blog.mbg.mapper.BlAdminMapper;
import com.zwy.blog.mbg.model.BlAdmin;
import com.zwy.blog.mbg.model.BlAdminExample;
import com.zwy.blog.mbg.model.BlPermission;
import com.zwy.blog.service.BlAdminService;

/**
 * BlAdminService实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class BlAdminServiceImpl implements BlAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BlAdminServiceImpl.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private BlAdminMapper adminMapper;
    @Autowired
    private BlAdminRoleRelationDao adminRoleRelationDao;

    @Override
    public BlAdmin getAdminByUsername(String username) {
        BlAdminExample example = new BlAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<BlAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public BlAdmin register(BlAdmin BlAdminParam) {
        BlAdmin BlAdmin = new BlAdmin();
        BeanUtils.copyProperties(BlAdminParam, BlAdmin);
        BlAdmin.setCreateTime(new Date());
        BlAdmin.setStatus(1);
        //查询是否有相同用户名的用户
        BlAdminExample example = new BlAdminExample();
        example.createCriteria().andUsernameEqualTo(BlAdmin.getUsername());
        List<BlAdmin> BlAdminList = adminMapper.selectByExample(example);
        if (BlAdminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(BlAdmin.getPassword());
        BlAdmin.setPassword(encodePassword);
        adminMapper.insert(BlAdmin);
        return BlAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }


    @Override
    public List<BlPermission> getPermissionList(Long adminId) {
        return adminRoleRelationDao.getPermissionList(adminId);
    }
}