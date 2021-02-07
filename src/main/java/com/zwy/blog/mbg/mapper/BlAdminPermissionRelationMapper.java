package com.zwy.blog.mbg.mapper;

import com.zwy.blog.mbg.model.BlAdminPermissionRelation;
import com.zwy.blog.mbg.model.BlAdminPermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlAdminPermissionRelationMapper {
    long countByExample(BlAdminPermissionRelationExample example);

    int deleteByExample(BlAdminPermissionRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlAdminPermissionRelation record);

    int insertSelective(BlAdminPermissionRelation record);

    List<BlAdminPermissionRelation> selectByExample(BlAdminPermissionRelationExample example);

    BlAdminPermissionRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlAdminPermissionRelation record, @Param("example") BlAdminPermissionRelationExample example);

    int updateByExample(@Param("record") BlAdminPermissionRelation record, @Param("example") BlAdminPermissionRelationExample example);

    int updateByPrimaryKeySelective(BlAdminPermissionRelation record);

    int updateByPrimaryKey(BlAdminPermissionRelation record);
}