package cn.zhangchi.mapper;

import cn.zhangchi.entity.Menu;
import cn.zhangchi.mapper.MenuExample;
import org.springframework.stereotype.Repository;

/**
 * MenuMapper继承基类
 */
@Repository
public interface MenuMapper extends MyBatisBaseDao<Menu, Integer, MenuExample> {
}