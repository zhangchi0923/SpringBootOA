package cn.zhangchi.mapper;

import org.apache.ibatis.annotations.Mapper;

import cn.zhangchi.entity.User;

/**
 * UserMapper继承基类
 */
@Mapper
public interface UserMapper extends MyBatisBaseDao<User, Integer, UserExample> {
}