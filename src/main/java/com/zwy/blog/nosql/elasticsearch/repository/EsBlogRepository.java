package com.zwy.blog.nosql.elasticsearch.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.zwy.blog.nosql.elasticsearch.document.EsBlog;

/**
 *博客ES操作类
 * Created by macro on 2018/6/19.
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, Integer> {
    /**
     * 搜索查询
     *
     * @param title          博客标题
     * @param content        博客内容
     * @param page           分页
     * @return
     */
    Page<EsBlog> findByNameOrSubTitleOrKeywords(String title, String content, Pageable page);

}
