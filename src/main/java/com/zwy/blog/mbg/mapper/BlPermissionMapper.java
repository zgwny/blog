package com.zwy.blog.mbg.mapper;

import com.zwy.blog.mbg.model.BlPermission;
import com.zwy.blog.mbg.model.BlPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlPermissionMapper {
    long countByExample(BlPermissionExample example);

    int deleteByExample(BlPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlPermission record);

    int insertSelective(BlPermission record);

    List<BlPermission> selectByExample(BlPermissionExample example);

    BlPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlPermission record, @Param("example") BlPermissionExample example);

    int updateByExample(@Param("record") BlPermission record, @Param("example") BlPermissionExample example);

    int updateByPrimaryKeySelective(BlPermission record);

    int updateByPrimaryKey(BlPermission record);
}