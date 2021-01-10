--Drop Table
drop table Member cascade constraints;
drop table Event cascade constraints;
drop table Category cascade constraints;
drop table Notice cascade constraints;
drop table Board cascade constraints;
drop table Manager cascade constraints;
drop table Progress cascade constraints;
drop table Coupon cascade constraints;

--Drop Sequence
drop sequence Member_seq;
drop sequence Event_seq;
drop sequence Category_seq;
drop sequence Notice_seq;
drop sequence Board_seq;
drop sequence Manager_seq;
drop sequence Progress_seq;
drop sequence Coupon_seq;

--Create Sequence
create sequence Member_seq 
INCREMENT BY 1 start with 100001 MAXVALUE 199999 nocache;
create sequence Event_seq 
INCREMENT BY 1 start with 200001 MAXVALUE 299999 nocache;
create sequence Category_seq 
INCREMENT BY 1 start with 300001 MAXVALUE 399999 nocache;
create sequence Notice_seq 
INCREMENT BY 1 start with 400001 MAXVALUE 499999 nocache;
create sequence Board_seq 
INCREMENT BY 1 start with 500001 MAXVALUE 599999 nocache;
create sequence Manager_seq 
INCREMENT BY 1 start with 600001 MAXVALUE 699999 nocache;
create sequence Progress_seq 
INCREMENT BY 1 start with 700001 MAXVALUE 799999 nocache;
create sequence Coupon_seq 
INCREMENT BY 1 start with 800001 MAXVALUE 899999 nocache;

--1.Member
create table Member(
member_no VARCHAR2(20) not null, 
member_id VARCHAR2(20) not null, 
member_pw VARCHAR2(20) not null, 
member_name VARCHAR2(20) not null,
member_email VARCHAR2(100) not null,
member_point VARCHAR2(20) default 0,
member_step VARCHAR2(20) default 1,
member_rf VARCHAR2(30),
member_qr VARCHAR2(30),
item_pw VARCHAR2(30),
constraint Member_no_pk PRIMARY KEY(Member_No),
constraint Member_Id_uk UNIQUE(Member_Id)
);

--2.Event
create table Event(
event_no VARCHAR2(20), 
event_mgno VARCHAR2(20), 
event_name VARCHAR2(20), 
event_count VARCHAR2(20), 
event_point VARCHAR2(20), 
event_start DATE default sysdate, 
event_end Date,
event_duration VARCHAR2(20), 
member_no VARCHAR2(20),
constraint Event_no_pk PRIMARY KEY(Event_No)
);

--3.Category
create table Category(
category_no VARCHAR2(20), 
category_name VARCHAR2(20), 
constraint Category_no_pk PRIMARY KEY(Category_No)
);

--4.Notice
create table Notice(
notice_no VARCHAR2(20), 
notice_name VARCHAR2(500),
notice_date DATE default sysdate,
notice_content VARCHAR2(500),
constraint Notice_no_pk PRIMARY KEY(Notice_No)
);

--5.Board
create table Board(
board_no VARCHAR2(20), 
board_name VARCHAR2(500), 
board_sort VARCHAR2(20), 
board_date DATE default sysdate,
board_content VARCHAR2(500),
member_no VARCHAR2(20),
member_id VARCHAR2(20),
constraint Board_no_pk PRIMARY KEY(Board_No),
constraint Board_mno_fk FOREIGN KEY(Member_No) REFERENCES Member(Member_No),
constraint Board_ck check (Board_Sort in ('qna','suggestion')), 
constraint Board_mid_fk FOREIGN KEY(Member_id) REFERENCES Member(Member_id)
);

--6.Manager
create table Manager(
manager_no VARCHAR2(20), 
manager_id VARCHAR2(20), 
manager_pw VARCHAR2(20),
constraint Manager_no_pk PRIMARY KEY(Manager_No)
);

--7.Progress
create table Progress(
member_no VARCHAR2(20), 
service_sum VARCHAR2(20) default 0, 
category1 VARCHAR2(20) default 0,
category2 VARCHAR2(20) default 0,
category3 VARCHAR2(20) default 0,
constraint member_no_fk FOREIGN KEY(member_no) REFERENCES Member(member_no)
);

--8. Coupon
create table Coupon(
member_no VARCHAR2(20),
coupon_no VARCHAR2(20),
coupon_name VARCHAR2(20),
coupon_discount number(20),
coupon_date DATE default sysdate,
coupon_valid VARCHAR2(30),
constraint Coupon_no_fk FOREIGN KEY(member_no) REFERENCES Member(member_no)
);


--desc Line
desc Member;
desc Event;
desc Category;
desc Notice;
desc Board;
desc Manager;
desc Progress;
desc Coupon;


commit;


