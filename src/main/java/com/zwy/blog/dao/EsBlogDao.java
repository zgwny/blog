package com.zwy.blog.dao;

import org.apache.ibatis.annotations.Param;

import com.zwy.blog.nosql.elasticsearch.document.EsBlog;

import java.util.List;

/**
 * 搜索系统中的博客管理自定义Dao
 */
public interface EsBlogDao {
    List<EsBlog> getAllEsBlogList(@Param("id") Integer id);
}
