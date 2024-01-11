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
	
//	select count(*), sum(score), avg(score), min(score), max(score) from score;
//	-- select နေရာမှာ group by နောက်က studentNumber ကိုပဲ ဆွဲထုတ်လို့ရတယ်
//	select subjectNumber, max(score) from score group by subjectNumber;
//	select subjectNumber, max(score) from score group by subjectNumber having max(score) >= 90;
//	select studentNumber, sum(score), count(score) from score group by studentNumber having studentNumber = 6724;
//
//	-- where condition ကိုတော့ group by မတိုင်ခင်ရေးရတယ်
//	select * from score;
//	select subjectNumber, count(*) noOfstudents from score 
//	where examinationDate = '2023-10-20'
//	group by subjectNumber
//	having count(*) > 1;
//
//	select count(distinct subjectNumber) noOfSubjects from score where examinationDate = '2023-10-20';
//	select studentNumber, count(distinct examinationDate) as numberofDays from score group by StudentNumber;
//
//	select * from student;
//	select gender, count(*) noOfstudents from student group by gender;
//	select max(studentNumber) from student
//	where studentName like '%yamamoto';
	
	
//	Sorting of data
//	select * from student order by studentName desc;
//	select * from student order by gender, studentName desc;
//	select * from student order by gender desc, studentName;

	
//	Limit
//	select * from score;
//	-- အမှတ်အများဆုံး 2 ခုလိုချင်ရင် => order by & limit
//	select * from score order by score desc limit 2;
//	-- အရှေ့က 2 က skip လုပ်သွားတဲ့ row အရေအတွက် => data ကို user အား ခွဲပြတဲ့အခါတွေမှာသုံးတယ် pagination ပုံစံမျိုး
//	select * from score limit 2, 3;
	
	
//	Joining the tables
	
//	select * from score;
//	select * from student;
//	-- cross join
//	select * from score, student;
//	-- equijoin = innerjoin
//	select * from student s, score c where s.StudentNumber = c.studentNumber;
//	select * from student s inner join score c on s.studentNumber = c.studentNumber;
//	select StudentName, SubjectNumber, Score from student s
//	inner join score c on s.studentNumber = c.studentNumber;
//
//	select s.*, SubjectName, Score from student s, score c, `subject` u
//	where s.StudentNumber = c.studentNumber and c.subjectNumber = u.subjectNumber ;
//
//	-- record data တူတာမရှိလည်း ထုတ်ချင်တယ်ဆိုရင် outer join သုံး => left outer join, right outer join
//	select * from score;
//	select * from student;
//	-- left join က အရင်လာတဲ့ table(left) ကို အတည်ယူပြီး ချိတ်ခြင်း
//	select * from student s left join score sc on s.studentNumber = sc.studentNumber;
//	-- -- left join က နောက်က table(right) ကို အတည်ယူပြီး ချိတ်ခြင်း
//	select * from student s right join score sc on s.studentNumber = sc.studentNumber;
//
//	-- join လို့ပဲရေးရင် inner join
//	select * from student s join score c on s.studentNumber = c.studentNumber;
	
	
	
	
	
	
	
	
	
	

}
