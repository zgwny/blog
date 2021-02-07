package com.zwy.blog.dao;

import com.zwy.blog.mbg.model.BlPermission;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 */
public interface BlAdminRoleRelationDao {

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<BlPermission> getPermissionList(@Param("adminId") Long adminId);
}