package com.zwy.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by macro on 2021/1/23.
 */
@Configuration
@MapperScan({"com.zwy.blog.mbg.mapper","com.zwy.blog.dao"})
public class MyBatisConfig {
}
