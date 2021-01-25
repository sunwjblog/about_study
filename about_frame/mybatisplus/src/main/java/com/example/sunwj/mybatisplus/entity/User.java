package com.example.sunwj.mybatisplus.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/21 12:09 上午
 */
@Data
public class User {

    private Long id;

    private String name;

    private Integer age;

    private String email;

    private Long managerId;

    private LocalDateTime createTime;
}
