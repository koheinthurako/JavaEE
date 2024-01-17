package QueryCollection;

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
	
	
//	EXERCIES
	
//	select * from student;
//	select * from score;
//	select * from subject;
//	select distinct studentName from student s join score sc
//	on s.studentNumber = sc.studentNumber and sc.score >= 80;
//
//	select studentName, sj.subjectName from student s, score sc, `subject` sj
//	where s.studentNumber = sc.studentNumber and sj.subjectNumber = sc.subjectNumber and sc.score >= 80;
//
//	select studentName, count(*) as Distinction from student s
//	join score sc on s.studentNumber = sc.studentNumber and sc.score >= 80
//	group by studentName;
//
//	select subjectName, avg(sc.score) Average from score sc, `subject` sj
//	where sc.subjectNumber = sj.subjectNumber
//	group by subjectName;
//
//	select subjectName, count(*) totalPeople from score sc join `subject` sj
//	on sc.subjectNumber = sj.subjectNumber
//	group by subjectName
//	order by totalPeople;
//
//	select studentName from student s join score sc
//	on s.studentNumber = sc.studentNumber
//	where sc.examinationDate = '2023-10-20' and s.gender = 'Male'
//	group by studentName
//	order by studentName;
	
	
//	Creating View
	
//	-- Creating View (Virtual Table) မူရင်းမဟုတ်ပဲ တစ်ခုခုကနေထွက်လာတဲ့ table တစ်စိတ်တစ်ပိုင်းကို virtual ထုတ်ကြည့်ခြင်း
//	-- view ကိုသုံးရင် application ဘက်က query ရေးစရာမလိုတော့ပဲ သက်သာသွားတယ်
//	create view studentNames as
//	select studentNumber, studentName from student;
//	-- view table ကို data update လုပ်ရင် မူရင်း table မှာလည်းပြောင်းသွားတယ်
//	-- view ကိုပြင်လို့ရမရက view table နဲ့ မူရင်း table တွေရဲ့ primary key တူတဲ့အပေါ်မှာမူတည်တယ် တူရင် နှစ်ခုလုံးပြောင်းတယ်
//	update studentNames set studentName = 'Mone' where studentNumber = 6816;
//	select * from studentNames;
//
//	create view distinctionCount as
//	select studentName, count(*) as Distinction from student s
//	join score sc on s.studentNumber = sc.studentNumber and sc.score >= 80
//	group by studentName;
//	select * from distinctionCount;
//	-- အပေါ်ကလို aggreagate fun တွေကမှထွက်လာတဲ့ table တွေဆိုရင် view မှာသွားပြင်လို့မရတော့ဘူး
//
//	/*
//		view ကိုသုံးရတဲ့အဓိကရည်ရွယ်ချက်က program တစ်ခုရေးလို့ database access မှတစ်ဆင့် data ယူတဲ့အခါ
//	    အပေါ်က query အရှည်ကြီးထဲက Distinction 3 ခုရတဲ့ လူကိုယူချင်တယ်ဆိုပြီး လှမ်းယူတဲ့အခါ
//	    program code တွေထဲမှာ အပေါ်ကအတိုင်း query အရှည်ကြီးရေးနေရမှာမို့ DB ထဲမှာပဲ juery အရှည်ကြီးရေးထားတဲ့ view ကို တည်ဆောက်ထားပြီးမှ
//	    အောက်ကလို ကိုယ်လိုချင်တဲ့ program code ကို တိုတိုပြန်ရေးလို့လွယ်ကူသွားတဲ့အတွက် သုံးကြတာများတယ်
//	    Base table ကနေ တည်ဆောက်ထားလို့ data consistency မဖြစ်မှာကိုလည်း စိုးရိမ်စရာမလို
//	*/
//	select * from distinctionCount
//	where distinction >= 3;
	
	
//	Sub Query
	
//	select * from score;
//	-- သီးသန့် run လို့ရတဲ့ independent subquery
//	 select studentName from student
//	 where studentNumber in (
//		select studentNumber from score
//	    where examinationDate = '2023-10-20'
//	 );
//
//	-- သီးသန့် မ run နိုင်တဲ့ correlation subquery
//	select studentName from student s
//	where exists (
//		select * from score sc
//	    where s.studentNumber = sc.studentNumber
//	    and examinationDate = '2023-10-20'
//	);
//
//	-- not exists ဆိုရင်တော့ ထွက်လာတဲ့ result ထဲမှာ မပါတဲ့ data ကိုထုတ်ပေးတယ်
//	select studentName from student s
//	where not exists (
//		select * from score sc
//	    where s.studentNumber = sc.studentNumber
//	    and examinationDate = '2023-10-20'
//	);
//
//	select studentName from student
//	where studentNumber in  (
//		select studentNumber from score
//	    where score >= 80
//	);
//
//	select * from score;
//	select count(*), subjectNumber from score 
//	group by subjectNumber
//	having count(*) > 1;
//
//	select subjectName from subject
//	where subjectNumber in (
//		select subjectNumber from score 
//		group by subjectNumber
//		having count(*) > 1
//	); 
//
//	select * from subject;
//	select * from score;
//	select subjectName from subject sj
//	where exists (
//		select subjectNumber from score sc
//	    where sj.subjectNumber = sc.subjectNumber
//		group by subjectNumber
//		having count(*) > 1
//	); 
//
//	select avg(score) from score group by subjectNumber;
//	-- avg ရှာလိုက်တဲ့ တန်ဖိုးတွေထဲက တစ်ခုခုနဲ့ကြီးရင်ရပြီဆိုပြီး တိုက်စစ်တဲ့အတွက် အနည်းဆုံးဖြစ်တဲ့ 75 ထက်ကြီးတဲ့ data တွေထုတ်ပေးတယ်
//	select * from score
//	where score > any (
//		select avg(score) from score group by subjectNumber
//	);
//
//	select * from score
//	where score > all (
//		select avg(score) from score group by subjectNumber
//	);
//
//
//	-- subquery ကို table တစ်ခုအနေနဲ့ ယူသုံးခြင်း
//	select studentNumber, count(*) distinction from score
//	where score >= 80
//	group by studentNumber;
//
//	-- subquery ကို table တစ်ခုအနေနဲ့ equi join ကိုသုံးပြီးတော့ function တစ်ခုလို subquery က ပြန်လာတဲ့ return ကိုအခြေခံ condition ထပ်စစ်ပြီးထုတ်
//	select studentName, distinction from student s, (
//		select studentNumber, count(*) distinction from score
//		where score >= 80
//		group by studentNumber
//	) d where s.studentNumber = d.studentNumber;
	
	
//	Using Case
	
//	-- Using Case => ထွက်လာတဲ့ record ကိုသူ့အတိုင်းမထုတ်ချင်ပဲ ပုံစံပြောင်းချင်ရင် case ကိုသုံးတယ်
//		select studentNumber, subjectNumber, score,
//		case 
//			when score between 0 and 39 then 'Fail'
//		    when score between 40 and 79 then 'Pass'
//		    when score > 79 then 'Distinction'
//		end as Grade
//		from score;
	
	
	
//	Stored Procedure
	
//	Stored Procedure ဆိုတာဘာလဲ? => java ထဲမှာလို method တွေကို Database မှာရေးနိုင်တဲ့ feature
//	ဥပမာ : score တစ်ခုအသစ်ထည့်လိုက်လို့ values ထဲမှာ score မပါလာဘူးဆိုရင် တန်ဖိုးကို default ကို auto "40" ဖြစ်အောင်ထည့်ပေးမယ်
//	StoredProcedured.java ထဲမှာ procedure တစ်ခုကိုထည့်လိုက်ပြီ အဲ့တာကို အောက်မှာ call ပြီး score အသစ်တစ်ခုထပ်ထည့်လိုက်တယ်
//	call add_score(6726, 'K12', '2023-10-21');
	
	
	

}
