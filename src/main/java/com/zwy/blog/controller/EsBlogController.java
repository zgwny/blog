package com.zwy.blog.controller;

import com.zwy.blog.common.api.CommonPage;
import com.zwy.blog.common.api.CommonResult;
import com.zwy.blog.nosql.elasticsearch.document.EsBlog;
import com.zwy.blog.service.EsBlogService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 搜索博客管理Controller
 */
@Controller
@Api(tags = "EsBlogController", description = "搜索博客管理")
@RequestMapping("/esBlog")
public class EsBlogController {
    @Autowired
    private EsBlogService esBlogService;

    @ApiOperation(value = "导入所有数据库中博客到ES")
    @RequestMapping(value = "/importAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> importAllList() {
        int count = esBlogService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "根据id删除博客")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Object> delete(@PathVariable Integer id) {
        esBlogService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id批量删除博客")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Object> delete(@RequestParam("ids") List<Integer> ids) {
        esBlogService.delete(ids);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id创建博客")
    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<EsBlog> create(@PathVariable Integer id) {
        EsBlog esBlog = esBlogService.create(id);
        if (esBlog != null) {
            return CommonResult.success(esBlog);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "简单搜索")
    @RequestMapping(value = "/search/simple", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsBlog>> search(@RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsBlog> esBlogPage = esBlogService.search(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esBlogPage));
    }

}