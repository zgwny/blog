package com.zwy.blog.mbg.mapper;

import com.zwy.blog.mbg.model.BlRole;
import com.zwy.blog.mbg.model.BlRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlRoleMapper {
    long countByExample(BlRoleExample example);

    int deleteByExample(BlRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlRole record);

    int insertSelective(BlRole record);

    List<BlRole> selectByExample(BlRoleExample example);

    BlRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlRole record, @Param("example") BlRoleExample example);

    int updateByExample(@Param("record") BlRole record, @Param("example") BlRoleExample example);

    int updateByPrimaryKeySelective(BlRole record);

    int updateByPrimaryKey(BlRole record);
}