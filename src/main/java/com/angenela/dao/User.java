package com.angenela.dao;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String password;
    private Long createTime;
    private String authority;
    private String token;
}
