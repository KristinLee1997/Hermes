CREATE DATABASE `hermes_aries_hotel` character set utf8mb4;
use `hermes_aries_hotel`;

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



