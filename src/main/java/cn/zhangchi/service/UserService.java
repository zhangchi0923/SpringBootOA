package cn.zhangchi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.zhangchi.entity.User;
import cn.zhangchi.mapper.UserExample;
import cn.zhangchi.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;

	public User findByLoginNameAndPassword(String loginName, String password) {

		UserExample example = new UserExample();
		example.createCriteria()
		.andLoginNameEqualTo(loginName)
		.andPasswordEqualTo(password);
		
		List<User> users = userMapper.selectByExample(example);
		
		return users.size() == 0?null:users.get(0);
	}

	public List<User> findAll() {
		
		UserExample example = new UserExample();
		return userMapper.selectByExample(example );
		
	}

	public PageInfo<User> findByPage(int pageNum, int pageSize) {

		PageHelper.startPage(pageNum, pageSize);
		
		UserExample example = new UserExample();
		List<User> list = userMapper.selectByExample(example);
		
		return new PageInfo<>(list);
	}

//	public List<User> findByPage(int pageNum, int pageSize) {
//
//		PageHelper.startPage(pageNum, pageSize);
//		UserExample example = new UserExample();
//		return userMapper.selectByExample(example);
//	}

//	public PageInfo<User> findByPage(String pageNum, String pageSize) {
//
//		PageHelper.
//		
//		return null;
//	}

}
