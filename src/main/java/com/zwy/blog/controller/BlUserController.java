package com.zwy.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zwy.blog.common.api.CommonPage;
import com.zwy.blog.common.api.CommonResult;
import com.zwy.blog.mbg.model.BlUser;
import com.zwy.blog.service.BlUserService;

@RestController
@RequestMapping("/api/user")
public class BlUserController {
	
	@Autowired
	private BlUserService service;

	@GetMapping("/list")
    public CommonResult<CommonPage<BlUser>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<BlUser> userList = service.listUser(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(userList));
    }
	
}
