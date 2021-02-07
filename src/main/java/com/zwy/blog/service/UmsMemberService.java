package com.zwy.blog.service;

import com.zwy.blog.common.api.CommonResult;

/**
 * 会员管理Service
 * Created by zgwny on 2021/1/24.
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);

}

