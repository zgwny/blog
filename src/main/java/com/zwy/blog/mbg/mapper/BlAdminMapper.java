package com.zwy.blog.mbg.mapper;

import com.zwy.blog.mbg.model.BlAdmin;
import com.zwy.blog.mbg.model.BlAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlAdminMapper {
    long countByExample(BlAdminExample example);

    int deleteByExample(BlAdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlAdmin record);

    int insertSelective(BlAdmin record);

    List<BlAdmin> selectByExample(BlAdminExample example);

    BlAdmin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlAdmin record, @Param("example") BlAdminExample example);

    int updateByExample(@Param("record") BlAdmin record, @Param("example") BlAdminExample example);

    int updateByPrimaryKeySelective(BlAdmin record);

    int updateByPrimaryKey(BlAdmin record);
}