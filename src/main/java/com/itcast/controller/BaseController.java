package com.itcast.controller;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BaseController {

    public void rentToJson(String jo, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        PrintWriter pr = null;
        try {
            pr = response.getWriter();
            pr.write(jo);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(pr != null){
                pr.close();
            }
        }
    }
}
