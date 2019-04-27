package com.aries.hermes.dal.po;

import lombok.Data;

@Data
//可以注解指定表名
//@Table(name = "stu")
public class Stu {
    private Integer id;

    // 可以注解指定列名
    // @Column(name = "name")
    private String name;
}
