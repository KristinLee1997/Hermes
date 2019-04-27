CREATE DATABASE `test`


create table test.stu
(
	id int auto_increment
		primary key,
	name varchar(20) null
);

INSERT INTO test.stu (id, name) VALUES (1, 'king');