package com.zwy.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zwy.blog.common.api.CommonPage;
import com.zwy.blog.common.api.CommonResult;
import com.zwy.blog.mbg.model.BlUser;
import com.zwy.blog.service.BlUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 博客管理Controller
 */
@Api(tags = "BlBlogController", description = "博客管理")
@RestController
@RequestMapping("/api/blog")
public class BlBlogController {
	
	@Autowired
	private BlUserService service;

	@ApiOperation("分页查询博客")
	@RequestMapping(value = "listAll", method = RequestMethod.GET)
	@GetMapping("/list")
	@PreAuthorize("hasAuthority('pms:brand:read')")
	public CommonResult<CommonPage<BlUser>> listBrand(
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
		List<BlUser> userList = service.listUser(pageNum, pageSize);
		return CommonResult.success(CommonPage.restPage(userList));
	}

}
