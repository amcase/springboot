package com.itcast.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.itcast.bean.InitData;
import com.itcast.common.JqJSONResponse;
import com.itcast.common.Msg;
import com.itcast.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class LoginController extends BaseController{
    private Logger logger = Logger.getLogger(LoginController.class);
    @Autowired
    private UserService userService;

    /**
     *  系统首页
     * @param request
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        String root = request.getContextPath();
        request.setAttribute("root",root);
        return "view/index";
    }

    /**
     *  登陆
     * @param request
     * @param response
     * @return
     */
    public void login(HttpServletRequest request,HttpServletResponse response){
        Msg msg = new Msg();
        int flag = userService.login(request);
        if(flag == 1){
            msg.setStatus(200);
            msg.setDescribe("登陆成功");
        }else{
            msg.setStatus(200);
            msg.setDescribe("登陆失败");
        }
        this.rentToJson(msg.toJSONString(),response);
        //return "messageList";
    }

    /**
     * 注册
     * @param request
     * @param response
     */
    @RequestMapping("/regist")
    public void tk(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("userName");
        String password = request.getParameter("password");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stu",1);
        jsonObject.put("name","1111");
        this.rentToJson(jsonObject.toJSONString(),response);
    }
    @RequestMapping("/getData")
    public void initDate(HttpServletResponse response){
        List<InitData> list = new ArrayList<>();
        for(int i = 0;i<30;i++){
            InitData in = new InitData();
            in.setId(UUID.randomUUID().toString());
            in.setName("张三"+i);
            in.setPay(100.22+i*33);
            in.setText("随便什么");
            in.setType(i%2);
            list.add(in);
        }
        PageInfo<InitData> result = new PageInfo<>(list);
        JSONObject jo = new JSONObject();
        jo.put("page",result.getPageNum());
        jo.put("total",result.getPages());
        jo.put("records",result.getTotal());
        jo.put("rows",result.getList());
        this.rentToJson(jo.toString(),response);
    }


}
