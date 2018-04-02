package com.itcast.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class JqJSONResponse extends JSONObject implements Serializable {
    private static final long seriaizableVersionUID = 1L;
}
