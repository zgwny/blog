package com.zwy.blog.service;

import com.zwy.blog.nosql.elasticsearch.document.EsBlog;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 博客搜索管理Service
 */
public interface EsBlogService {
	/**
	 * 从数据库中导入所有博客到ES
	 */
	int importAll();

	/**
	 * 根据id删除博客
	 */
	void delete(Integer id);

	/**
	 * 根据id创建博客
	 */
	EsBlog create(Integer id);

	/**
	 * 批量删除博客
	 */
	void delete(List<Integer> ids);

	/**
	 * 根据关键字搜索名称或者副标题
	 */
	Page<EsBlog> search(String keyword, Integer pageNum, Integer pageSize);

}
