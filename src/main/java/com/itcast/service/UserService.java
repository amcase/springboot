package com.itcast.service;

import com.itcast.bean.User;
import com.itcast.dao.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service("userService")
@Lazy
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public Map<String, Object> getById(long id) {
        return userMapper.getById(id);
    }


    public int login(HttpServletRequest request) {
        Map<String,Object> map_param = new HashMap<>();
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("password");
        String loginIp = request.getParameter("loginIp");
        if(StringUtils.isNotBlank(userName)){
            map_param.put("userName",userName);
        }
        if(StringUtils.isNotBlank(pwd)){
            map_param.put("pwd",pwd);
        }
        if(StringUtils.isNotBlank(loginIp)){
            map_param.put("lgoinIp",loginIp);
        }
        return userMapper.login(map_param);
    }
    @Transactional

    public int regist(User user) {
        return userMapper.regist(user);
    }
    @Transactional

    public int update(User user) {
        return userMapper.update(user);
    }
}
