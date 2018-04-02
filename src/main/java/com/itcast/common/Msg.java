package com.itcast.common;

import com.alibaba.fastjson.JSONObject;

//统一信息返回类
public class Msg extends JSONObject{
    //访问状态 (200:访问正确)
    private int status;
    //返回数据
    private Object jo;
    //描述
    private String describe;
    //异常
    private Exception e;
    //异常码
    private String exceptionCode;

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getJo() {
        return jo;
    }

    public void setJo(Object jo) {
        this.jo = jo;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Exception getE() {
        return e;
    }

    public void setE(Exception e) {
        this.e = e;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
