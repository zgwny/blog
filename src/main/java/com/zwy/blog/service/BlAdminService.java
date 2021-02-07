package com.zwy.blog.service;


import java.util.List;

import com.zwy.blog.mbg.model.BlAdmin;
import com.zwy.blog.mbg.model.BlPermission;

/**
 * 后台管理员Service
 * Created by macro on 2018/4/26.
 */
public interface BlAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    BlAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    BlAdmin register(BlAdmin BlAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<BlPermission> getPermissionList(Long adminId);
}