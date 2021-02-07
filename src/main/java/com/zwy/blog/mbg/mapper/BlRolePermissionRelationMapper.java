package com.zwy.blog.mbg.mapper;

import com.zwy.blog.mbg.model.BlRolePermissionRelation;
import com.zwy.blog.mbg.model.BlRolePermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlRolePermissionRelationMapper {
    long countByExample(BlRolePermissionRelationExample example);

    int deleteByExample(BlRolePermissionRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlRolePermissionRelation record);

    int insertSelective(BlRolePermissionRelation record);

    List<BlRolePermissionRelation> selectByExample(BlRolePermissionRelationExample example);

    BlRolePermissionRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlRolePermissionRelation record, @Param("example") BlRolePermissionRelationExample example);

    int updateByExample(@Param("record") BlRolePermissionRelation record, @Param("example") BlRolePermissionRelationExample example);

    int updateByPrimaryKeySelective(BlRolePermissionRelation record);

    int updateByPrimaryKey(BlRolePermissionRelation record);
}