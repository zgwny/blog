package com.zwy.blog.mbg.mapper;

import com.zwy.blog.mbg.model.BlBlog;
import com.zwy.blog.mbg.model.BlBlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlBlogMapper {
    long countByExample(BlBlogExample example);

    int deleteByExample(BlBlogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlBlog record);

    int insertSelective(BlBlog record);

    List<BlBlog> selectByExampleWithBLOBs(BlBlogExample example);

    List<BlBlog> selectByExample(BlBlogExample example);

    BlBlog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlBlog record, @Param("example") BlBlogExample example);

    int updateByExampleWithBLOBs(@Param("record") BlBlog record, @Param("example") BlBlogExample example);

    int updateByExample(@Param("record") BlBlog record, @Param("example") BlBlogExample example);

    int updateByPrimaryKeySelective(BlBlog record);

    int updateByPrimaryKeyWithBLOBs(BlBlog record);

    int updateByPrimaryKey(BlBlog record);
}