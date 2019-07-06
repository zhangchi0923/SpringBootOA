package cn.zhangchi.mapper;

import cn.zhangchi.entity.User;
import cn.zhangchi.entity.UserExample;
import org.springframework.stereotype.Repository;

/**
 * UserMapper继承基类
 */
@Repository
public interface UserMapper extends MyBatisBaseDao<User, Integer, UserExample> {
}