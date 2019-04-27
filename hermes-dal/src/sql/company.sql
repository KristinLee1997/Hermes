create table company
(
    id           bigint auto_increment
        primary key,
    company_name varchar(50) null comment '公司名称',
    password     varchar(50) null comment '密码',
    keyword      varchar(50) null comment '注册码',
    add_time     timestamp   null comment '注册时间'
);
