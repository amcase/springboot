package com.itcast.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class InitData implements Serializable {
    private Long serialVersionUID = 1L;
    private String id;
    private int type;
    private double pay;
    private String name;
    private String text;

}
