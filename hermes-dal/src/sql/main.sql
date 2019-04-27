CREATE DATABASE `hermes_aries_hotel` character set utf8mb4;

use `hermes_aries_hotel`;

create table topic
(
	id bigint auto_increment
		primary key,
	theme varchar(100) null comment '帖子主题',
	content mediumtext null comment '帖子内容',
	gaea_id bigint null comment '主帖发起人id',
	anonymous_send tinyint(1) default 0 null comment '主帖是否匿名发送',
	anonymous_reply tinyint(1) default 0 null comment '是否允许匿名回复',
	category_id bigint null comment '帖子标签，种类',
	update_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '帖子更新时间',
	insert_time timestamp default CURRENT_TIMESTAMP null comment '新建帖子时间'
);

create index topic_category_id_index
	on topic (category_id);

create index topic_gaea_id_index
	on topic (gaea_id);

create index topic_update_time_index
	on topic (update_time);



create table reply
(
	id bigint auto_increment,
	topic_id bigint null comment '一级贴id',
	gaea_id bigint null comment '账号id',
	content MEDIUMTEXT null comment '内容',
	insert_time timestamp default CURRENT_TIMESTAMP null,
	update_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
	anonymous_send boolean default false null comment '是否匿名回答。默认不匿名。false不匿名。true匿名。',
	constraint reply_pk
		primary key (id)
);

create index reply_gaea_id_index
	on reply (gaea_id);

create index reply_update_time_index
	on reply (update_time desc);



create table sub_reply
(
	id bigint auto_increment,
	reply_id bigint null comment '二级贴id',
	sender_gaea_id bigint null comment '发送人',
	receiver_gaea_id bigint null comment '接收人',
	content MEDIUMTEXT null comment '内容',
	insert_time TIMESTAMP default CURRENT_TIMESTAMP null,
	constraint sub_reply_pk
		primary key (id)
);

create index sub_reply_sender_gaea_id_index
	on sub_reply (sender_gaea_id);

create index sub_reply_receiver_gaea_id_index
	on sub_reply (receiver_gaea_id);

create index sub_reply_reply_id_index
	on sub_reply (reply_id);

create index sub_reply_insert_time_index
	on sub_reply (insert_time);




create table category
(
	id bigint auto_increment,
	name varchar(20) null,
	constraint category_pk
		primary key (id)
);


