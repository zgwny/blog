package com.zwy.blog.mbg.mapper;

import com.zwy.blog.mbg.model.BlUser;
import com.zwy.blog.mbg.model.BlUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlUserMapper {
    long countByExample(BlUserExample example);

    int deleteByExample(BlUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(BlUser record);

    int insertSelective(BlUser record);

    List<BlUser> selectByExample(BlUserExample example);

    BlUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") BlUser record, @Param("example") BlUserExample example);

    int updateByExample(@Param("record") BlUser record, @Param("example") BlUserExample example);

    int updateByPrimaryKeySelective(BlUser record);

    int updateByPrimaryKey(BlUser record);
}