create database matching;
use matching;

use matching;
delete from student;
delete from teacher;
drop table student;
drop table teacher;
drop table subject;

create table student(
s_num int(30) auto_increment primary key,
name varchar(10),
password varchar(20),
s_email varchar(20) unique,
s_phone varchar(20),
s_tag varchar(20)
);
select * from student;

create table teacher(
t_num int(30) auto_increment primary key,
name varchar(10),
password varchar(20),
t_email varchar(20) unique,
t_phone varchar(20)
);

use matching;
select * from student;
select * from teacher;
insert into student(name,password,s_email,s_phone,s_tag) values("6","6","6","6","t    e    s    t");

 
drop table subject;
create table subject(
sub_num int(30) primary key,
sub_count varchar(20),
sub_score int(5),
t_email varchar(20),
s_email varchar(20),
total varchar(50),
subname varchar(20),
start varchar(20),
end varchar(20),
cost int(20),
tag varchar(20)
);

ALTER TABLE subject ADD FOREIGN KEY (t_email) REFERENCES teacher(t_email);
ALTER TABLE subject ADD FOREIGN KEY (s_email) REFERENCES student(s_email);


drop table board;
create table board(
code int(20) auto_increment primary key,
title varchar(100),
content varchar(500),
writer varchar(20),
email varchar(30),
reg_datetime timestamp default now(),
viewcnt int default 0
);

insert into board (title,content,writer,email,reg_datetime) values("첫번재제목","1내용","이유림","dlddbfladl@naver.com", now());
insert into board (title,content,writer,email,reg_datetime) values("두번째제목","2내용","둘쓴이","dlddbfladl2@naver.com", now());
insert into board (title,content,writer,email,reg_datetime) values("3번재제목","3내용","셋쓴이","dlddbfladl3@naver.com", now());
select * from board;
select *,(select count(*) from reply where code=board.code) as recnt from board;
select * from board order by originNo desc, groupOrd desc;

select s_email from student;




drop table reply;
create table reply(
rno int(10) auto_increment primary key,
code int(10),
replytext varchar(500),
replyer varchar(500),
reg_datetime Timestamp default now(),
reg_updatetime Timestamp default now()
);
select * from reply;

delete from reply where replyer="쓴이";
insert into reply(code,replytext,replyer) values (1,"추가적으로 물어보고 싶은것은","첫쓴이");
insert into reply(code,replytext,replyer) values (1,"어떻게 해야될지 모르겠어요","첫쓴이");
insert into reply(code,replytext,replyer) values (2,"계좌이체로 하는거 맞나요?","들쓴이");
insert into reply(code,replytext,replyer) values (2,"카드결제 안되는곳이 세상에 어디있습니까","hello작성자2");
insert into reply(code,replytext,replyer) values (2,"야 댓글 나오냐","셋쓴이");
insert into reply(code,replytext,replyer) values (2,"나온다","넷쓴이");
select * from reply;

select r.rno,r.code,replytext,r.replyer, r.reg_datetime from reply r left outer join board b on r.code=b.code;
select rno,r.code,replytext,r.replyer, r.reg_datetime from reply r where r.code=2 order by rno;
select rno,r.code,replytext,replyer,r.reg_datetime from reply r,board m where r.replyer=m.writer and r.code=2 order by rno;
select b.code,b.title,b.content,b.writer,b.reg_datetime,b.viewcnt,(select count(*) from reply where code=r.code) as recnt from board b, reply r order by r.code desc, r.reg_datetime;
select * from reply where code=2;