package com.zwy.blog.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.zwy.blog.mbg.mapper.BlUserMapper;
import com.zwy.blog.mbg.model.BlUser;
import com.zwy.blog.mbg.model.BlUserExample;
import com.zwy.blog.service.BlUserService;

@Service
public class BlUserServiceImpl implements BlUserService {

	@Autowired
	private BlUserMapper blUserMapper;

	@Override
	public List<BlUser> listAllBrand() {
		// TODO Auto-generated method stub
		return blUserMapper.selectByExample(new BlUserExample());
	}

	@Override
	public int createUser(BlUser user) {
		// TODO Auto-generated method stub
		return blUserMapper.insertSelective(user);
	}

	@Override
	public int updateBrand(int id, BlUser user) {
		// TODO Auto-generated method stub
		user.setUserId(id);
		return blUserMapper.updateByExampleSelective(user, new BlUserExample());
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return blUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<BlUser> listUser(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return blUserMapper.selectByExample(new BlUserExample());
	}

	@Override
	public BlUser getUser(int id) {
		return blUserMapper.selectByPrimaryKey(id);
	}

}
