package com.angenela.dao;

import lombok.Data;

@Data
public class Article {
    private Integer id;
    private Long createTime;
    private String title;
    private String text;
    private boolean comment;
    private String description;
    private String tags;
}
