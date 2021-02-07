package com.zwy.blog.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.zwy.blog.mbg.model.BlAdmin;
import com.zwy.blog.mbg.model.BlPermission;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 */
public class AdminUserDetails implements UserDetails {
    private BlAdmin BlAdmin;
    private List<BlPermission> permissionList;
    public AdminUserDetails(BlAdmin BlAdmin, List<BlPermission> permissionList) {
        this.BlAdmin = BlAdmin;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return permissionList.stream()
                .filter(permission -> permission.getValue()!=null)
                .map(permission ->new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return BlAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return BlAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return BlAdmin.getStatus().equals(1);
    }
}
