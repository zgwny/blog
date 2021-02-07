package com.zwy.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.zwy.blog.common.api.CommonResult;
import com.zwy.blog.dto.BlAdminLoginParam;
import com.zwy.blog.mbg.model.BlAdmin;
import com.zwy.blog.mbg.model.BlPermission;
import com.zwy.blog.service.BlAdminService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户管理
 */
@Controller
@Api(tags = "BlAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class BlAdminController {
    @Autowired
    private BlAdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<BlAdmin> register(@RequestBody BlAdmin BlAdminParam, BindingResult result) {
        BlAdmin BlAdmin = adminService.register(BlAdminParam);
        if (BlAdmin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(BlAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody BlAdminLoginParam BlAdminLoginParam, BindingResult result) {
        String token = adminService.login(BlAdminLoginParam.getUsername(), BlAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<BlPermission>> getPermissionList(@PathVariable Long adminId) {
        List<BlPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }
}