package DBTest;

public class QueryCollection {
	
//	DDL => Data Definition Language
	
//	create database test;
//	use test;
//
//	-- DDL
//	create table subject (
//		SubjectNumber varchar(3) primary key,
//	    SubjectName varchar(10)
//	);
//
//	create table student (
//		StudentNumber int primary key,
//	    StudentName varchar(30),
//	    gender varchar(6)
//	);
//
//	create table score (
//		StudentNumber int,
//	    SubjectNumber varchar(3),
//	    Score int check (score >= 0),
//	    ExaminationDate date not null,
//	    primary key (StudentNumber, SubjectNumber),
//	    foreign key (StudentNumber) references student(StudentNumber),
//	    foreign key (SubjectNumber) references subject (SubjectNumber)
//	);
//
//	insert into subject values ('K11', 'English I');
//	insert into subject values ('K12', 'English II'), ('K21', 'Maths');
//
//	insert into student values (6724, 'Kazuki Yamamoto', 'Male'),
//	(6725, 'Jyugo Motoyama', 'Male'), (6816, 'Mone Yamada', 'Female'), (6817, 'Chiyo Yamamoto', 'Female');
//
//	insert into score values (6724, 'K11', 65, '2023-10-20'), (6724, 'K21', 85, '2023-10-21'),
//	(6725, 'K21', 60, '2023-10-20'), (6817, 'K11', 85, '2023-10-20'),
//	(6817, 'K12', 90, '2023-10-20'), (6817, 'K21', 95, '2023-10-21');
//
//	delete from score where StudentNumber = 6817 and SubjectNumber = 'K21';
//	update student set StudentName = 'Ko Hein' where StudentNumber = 6724;
	
	
//	__________________________________________________________________________________________________________
	
	
//	DML => Data Manipulation Language
	
//	select studentName from student;
//	select * from student where gender = 'male';
//	select * from student where gender <> 'male';
//	select distinct gender from student;
//
//	select * from score;
//	select * from score where score >= 65 and score <= 90;
//	select * from score where score between 65 and 90;
//	select * from score where score > 65 and subjectNumber = 'K21';
//	select * from student where studentName like '%he%';
//	select * from student  where studentName like '%yama____';
//	select * from score where (subjectNumber like '%2%') or (score between 80 and 90);
//	select * from score where score > 60 and (studentNumber like '_7__' or ExaminationDate = '2023-10-21');
	
//	Group By
	
	
	
	
	
	
	

}
