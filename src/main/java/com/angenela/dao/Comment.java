package com.angenela.dao;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ToString
public class Comment {
    private Integer id;
    private Integer articleId;

    @Length(message = "101", max = 32)
    private String name;

    @NotEmpty(message = "201")
    @NotNull(message = "201")
    @Length(message = "102", max = 1024)
    private String text;

    @Length(message = "103",max = 15)
    private String qq;

    private Long createTime;
    private boolean agree;
}
