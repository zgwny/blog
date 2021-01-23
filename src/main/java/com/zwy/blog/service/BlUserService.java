package com.zwy.blog.service;

import java.util.List;

import com.zwy.blog.mbg.model.BlUser;

/**
 * BlUserService
 * created by zwy on 2021/1/23
 *
 */
public interface BlUserService {

	List<BlUser> listAllBrand();

    int createUser(BlUser user);

    int updateBrand(int id, BlUser user);

    int deleteUser(int id);

    List<BlUser> listUser(int pageNum, int pageSize);

    BlUser getUser(int id);
}
