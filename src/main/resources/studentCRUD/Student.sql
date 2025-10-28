show databases ;

create database testdb2;

use testdb2;

create table student(
id bigint primary key auto_increment comment '아이디',
name varchar(100) not null comment '이름',
email varchar(255) null comment '이메일',
age int default  null,
cerateAt timestamp null default current_timestamp(),
updateAt timestamp null default current_timestamp() on update current_timestamp()


);

show tables ;

select  id, name, email, age, cerated_at, updated_at from student;

insert into student(name, email, age, cerateAt, updateAt) VALUES
 ('','','',now(),now());

select  *from student where id='';

update student
set name ='',email='',age='',updateAt=''
where id ='';

delete from student where id='';

alter table student
change column creaed_at created_at datetime;

alter table student
    change column updateAt updated_at datetime;
