--1.Member
insert into Member(Member_No,Member_Id,Member_Pw,Member_Name,Member_Email,member_rf,member_step,member_point) 
VALUES(Member_seq.nextVal,'seojung','aa','seojeong','sj@naver.com','167130187180','3','230');
insert into Member(Member_No,Member_Id,Member_Pw,Member_Name,Member_Email,member_rf,member_step,member_point) 
VALUES(Member_seq.nextVal,'jonghan','aa','jonghan','jh@naver.com','741116726','2','100');
insert into Member(Member_No,Member_Id,Member_Pw,Member_Name,Member_Email,member_rf,member_step) 
VALUES(Member_seq.nextVal,'sooyong','aa','sooyong','sy@naver.com','18620249128','3');
insert into Member(Member_No,Member_Id,Member_Pw,Member_Name,Member_Email,member_rf,member_step) 
VALUES(Member_seq.nextVal,'songyun','aa','songyun','syun@naver.com','16921339195','4');
insert into Member(Member_No,Member_Id,Member_Pw,Member_Name,Member_Email,member_rf) 
VALUES(Member_seq.nextVal,'youngju','aa','youngju','yj@naver.com','122167116130');
insert into Member(Member_No,Member_Id,Member_Pw,Member_Name,Member_Email,member_rf) 
VALUES(Member_seq.nextVal,'jina','aa','jina','ja@naver.com','9192218185');
insert into Member(Member_No,Member_Id,Member_Pw,Member_Name,Member_Email,member_rf) 
VALUES(Member_seq.nextVal,'sumin','aa','sumin','so@naver.com','74154117130');

--2.Event
insert into Event(Event_No,Event_Mgno,Event_Name,Event_Count,Event_Point,Event_Duration) 
VALUES(Event_seq.nextval,'1','plastic','1','20','5');
insert into Event(Event_No,Event_Mgno,Event_Name,Event_Count,Event_Point,Event_Duration) 
VALUES(Event_seq.nextval,'1','namu','1','50','5');
insert into Event(Event_No,Event_Mgno,Event_Name,Event_Count,Event_Point,Event_Duration) 
VALUES(Event_seq.nextval,'1','echobag','1','10','7');

--3.Category
insert into Category(Category_No,Category_Name) 
VALUES(Category_seq.nextval,'trash');
insert into Category(Category_No,Category_Name) 
VALUES(Category_seq.nextval,'echobag');
insert into Category(Category_No,Category_Name) 
VALUES(Category_seq.nextval,'vendingmachine');

--4.Notice
insert into Notice(Notice_No,Notice_content,Notice_name) 
VALUES(Notice_seq.nextval,'Welcome to NorthBears World','confirm');
--insert into Notice(Notice_No,Notice_content,Notice_name) 
--VALUES(Notice_seq.nextval,'Today is earth day. How about turn off your light just 1minute?','confirm');
--insert into Notice(Notice_No,Notice_content,Notice_name) 
--VALUES(Notice_seq.nextval,'Corona19 is related everyone. but there is no people to do save earth','confirm');
--insert into Notice(Notice_No,Notice_content,Notice_name) 
--VALUES(Notice_seq.nextval,'Future is up to you','confirm');


--5.Board
insert into Board(Board_No,board_content,Board_Sort,Board_Name,Member_No,member_id) 
VALUES(Board_seq.nextval,'Could you plz add a page of plastic sorting in the Event?','suggestion','abc','100001', 'seojung');



--6.Admin
insert into Manager(manager_no,Manager_Id,Manager_pw) 
VALUES(Manager_seq.nextval,'admin','admin');


--7.Progress
insert into Progress(member_no, category1, category2, category3)
values('100001', '9', '21', '7');
insert into Progress(member_no, category1, category2, category3)
values('100016', '0', '0', '0');



commit;

