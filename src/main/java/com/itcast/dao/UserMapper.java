package com.itcast.dao;

import com.itcast.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Mapper
@Component
public interface UserMapper {
    /**
     * 根据 id 获取用户信息
     * @param id
     * @return
     */
    public Map<String,Object> getById(long id);

    /**
     * 用户登陆
     * @param user
     * @return
     */
    public int login(Map<String,Object> user);

    /**
     * 注册
     * @param user
     * @return
     */
    public int regist(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    public int update(User user);
}
