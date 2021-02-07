                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         package com.zwy.blog.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.zwy.blog.nosql.elasticsearch.repository.EsBlogRepository;
import com.zwy.blog.dao.EsBlogDao;
import com.zwy.blog.nosql.elasticsearch.document.EsBlog;
import com.zwy.blog.service.EsBlogService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 商品搜索管理Service实现类
 * Created by macro on 2018/6/19.
 */
@Service
public class EsBlogServiceImpl implements EsBlogService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsBlogServiceImpl.class);
    @Autowired
    private EsBlogDao blogDao;
    @Autowired
    private EsBlogRepository blogRepository;

    @Override
    public int importAll() {
        List<EsBlog> esBlogList = blogDao.getAllEsBlogList(null);
        Iterable<EsBlog> esBlogIterable = blogRepository.saveAll(esBlogList);
        Iterator<EsBlog> iterator = esBlogIterable.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public EsBlog create(Integer id) {
        EsBlog result = null;
        List<EsBlog> esBlogList = blogDao.getAllEsBlogList(id);
        if (esBlogList.size() > 0) {
            EsBlog esBlog = esBlogList.get(0);
            result = blogRepository.save(esBlog);
        }
        return result;
    }

    @Override
    public void delete(List<Integer> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            List<EsBlog> esBlogList = new ArrayList<>();
            for (Integer id : ids) {
                EsBlog esBlog = new EsBlog();
                esBlog.setId(id);
                esBlogList.add(esBlog);
            }
            blogRepository.deleteAll(esBlogList);
        }
    }

    @Override
    public Page<EsBlog> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return blogRepository.findByNameOrSubTitleOrKeywords(keyword,keyword, pageable);
    }

}