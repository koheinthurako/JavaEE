package entiryServiceImplTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entityServiceTest.studentServiceTest;
import entityTest.Student;

public class studentServiceImplTest implements studentServiceTest {

//	ဒီထဲမှာကတော့ implementation ဆိုသည့်အတိုင်း method တွေစရေးမယ်

	@Override
	public List<Student> get(Connection con) throws SQLException {
		List<Student> students = new ArrayList<Student>();
//		student ထဲက record တွေအကုန် ထုတ်မယ်
//		အောက်က variable 'SQL' က java ထဲမှာ ပုံမှန် string ဆိုပေမယ့် DB ထဲမှာတော့ query ဖြစ်တယ်
//		ဒါကြောင့် DB ထဲမှာ run နိုင်ဖို့အတွက် String ကို query statement အဖြစ်အလုပ်လုပ်နိုင်အောင် ပြောင်းပေးဖို့လိုတယ်
//		ပြောင်းပြီးရင်လည်း run နိုင်ဖို့အတွက် DB ကိုချိတ်ထားတဲ့ connection ကိုအရင်မှန်အောင် ချိတ်ဖို့လိုတယ် အဲ့လိုချိတ်ဖို့ connectorTest ထဲက ချိတ်ပြီးသား
//		connection con ကို passing ပေးမှရမယ် DB နဲ့အရင်ချိတ်ပြီးမှသာ အောက်က query ကို statement အဖြစ်ပြောင်းပြီး မှန်မှန်အလုပ်လုပ်နိုင်မယ်
//		ဒါကြောင့် java.sql.connection interface ထဲမှာ connection တစ်ခုကိုချိတ်လိုက်ပြီဆိုတာနဲ့ အဲ့ထဲမှာ connection တစ်ခုရှိသွားပြီမို့
//		ချိတ်ထားပြီးသား con ကို ဒီကနေပြန်ယူသုံးနိုင်သွားတယ်
		String sql = "select * from student";
//		con.createStatement() ကတော့ ချိတ်ထားတဲ့ con ရဲ့ DB ထဲမှာ stmt ဆိုတဲ့ DB statement တစ်ခုကို ဖန်တီးလိုက်တယ်
		Statement stmt = con.createStatement();
//		stmt က statement ဖြစ်သွားပြီမို့ executeQuery() နဲ့ String ကိုထည့်ပြီး run လိုက်တယ် return က ResultSet မို့ ResultSet နဲ့ပြန်လက်ခံ
//		DB ကနေ ယူလိုက်တဲ့ data တွေကို java ဘက်မှာ ResultSet နဲ့ ပြန်လက်ခံပေးရမယ်
		ResultSet set = stmt.executeQuery(sql);
//		set ထဲက data တွေက DB ကနေပြန်လာတဲ့ column တွေဖြစ်နေတော့ java ဘက်မှာ set ပြန်လုပ်ပြီး collection တစ်ခုထဲပြန်လက်ခံရမယ်
		while (set.next()) {
//			loop ပတ်ပြီး စလက်ခံမယ် set ထဲမှာ data မကုန်မချင်း loop ပတ်မှာမို့ condition ကို set.next() နဲ့ စစ်တယ်
//			set.getInt() ထဲက parameter ထဲမှာ DB column index ကိုထည့်ပေးရတယ် column index က DB မှာ 1 က စတယ်
//			column index မထည့်ချင်ရင် "studentName" နာမည်တိုက်ရိုက်ပေးပြီး ထည့်လို့ရတယ်
//			တကယ်တော့ loop ပတ်ပြီး output ထုတ်နိုင်ဖို့အတွက် Collection တစ်ခုတည်ဆောက်ပေးဖို့လိုတယ်
//			ResultSet ရဲ့ set က DB က return ပြန်လာတဲ့ Data တွေကိုပဲ getInt()/ getString() စတဲ့ method တွေသုံးပြီး လက်ခံပေးထားတာမို့
//			အဲ့ဒီ data တွေကို java ထဲမှာ ပြန်လက်ခံပြီးမှ ရေးထားတဲ့ entity class တွေထဲကို value တွေ passing ပေးရမယ်
			Student s = new Student();
//			ဒါကြောင့် သက်ဆိုင်တဲ့ object တွေဆောက်ပြီး value တွေ set လုပ်ပေးလိုက်တယ် 
			s.setStudentNumber(set.getInt(1));
			s.setStudentName(set.getString(2));
			s.setGender(set.getString(3));
//			ဒါဆိုရင်တော့ object တွေကန သက်ဆိုင်ရင် class ထဲကို object တစ်ခုရောက်သွားပြီမို့ output ထုတ်ဖို့ အပေါ်ဆုံးက arrayList ထဲကိုထည့်မယ်
			students.add(s);
//			ဒါဆိုရင်တော့ collection ရဲ့အလုပ်လုပ်တဲ့အတိုင်း student class ထဲက object တွေက
//			students ဆိုတဲ့ collection ထဲကို object အလိုက်ရောက်သွားပြီ
//			အားလုံးပြီးသွားတော့မှ return မှာ students ပြန်လိုက်တယ်
		}
		return students;
//		အားလုံးပြီးသွားရင် ConnectorTest ထဲကိုပြန်သွားကြည့်ပါ အဲ့ထဲမှာ ရှိတဲ့ method က အစက void သို့သော် အပေါ်မှာ ရေးထားတဲ့ program တွေကို run ဖို့က
//		OneStopTest ထဲမှာရေးမှာဆိုတော့ void method ကို Connection ပြောင်းပြီး connection တစ်ခု return ပြန်လိုက်ပြီး 
//		OneStopTest ထဲမှာ Connection object တစ်ခုဆောက်လိုက်တယ် ပြီးတော့ studentServiceImpl ကို run နိုင်ဖို့
//		သက်ဆိုင်တဲ့ object တစ်ခုဆောက်ပြီးတော့မှ method ကိုခေါ်ပြီး ဆောက်ထားတဲ့ connection object ကို
//		stuService.get(con) ဆိုပြီး parameter passing ပေးလိုက်တယ် ဒါဆိုရင် ဒီထဲက get method က အလုပ်လုပ်သွားပြီ သို့သော် 
//		ဒီကနေ ပြန်သွားတဲ့ return က students ဆိုတဲ့ object ကြီး အဲ့တာကို OneStopTest ထဲမှာ Collection တစ်ခုထဲထည့်ပြီးမှ
//		loop ပတ်ပြီး ပြန်ထုတ်ပြပေးရတယ်
	}

	@Override
	public Student insertStudent(Connection con, int id, String name, String gender) throws SQLException {
		Student stu = new Student();
		String sql = "insert into student values (?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.setString(3, gender);
		boolean checker = stmt.execute();
		if (!checker) {
			String sql2 = "select * from student where studentNumber = ?";
			stmt = con.prepareStatement(sql2);
			stmt.setInt(1, id);
			ResultSet set = stmt.executeQuery();
			set.next();
			stu.setStudentNumber(set.getInt(1));
			stu.setStudentName(set.getString(2));
			stu.setGender(set.getString(3));
			return stu;
		}
		return null;
	}

	@Override
	public boolean deleteByID(Connection con, int id) throws SQLException {
		String sql = "delete from student where studentNumber = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		System.err.println("Deleted!");
		return true;
	}

	@Override
	public List<Student> countGender(Connection con) throws SQLException {
		List<Student> students = new ArrayList<Student>();
		String sql = "select count(*), gender from student group by gender";
		Statement stmt = con.createStatement();
		ResultSet set = stmt.executeQuery(sql);
		while(set.next()) {
			Student stu = new Student();
			stu.setStudentNumber(set.getInt(1));
			stu.setGender(set.getString(2));
			students.add(stu);
		}
		return students;
	}

	@Override
	public List<Student> createView(Connection con) throws SQLException {
		String sql = "create view studentList as select studentNumber, studentName from student";
		Statement stmt = con.createStatement();
		stmt.execute(sql);
		System.out.println("Successfully created view!");
		String sql2 = "select * from studentList";
		ResultSet set = stmt.executeQuery(sql2);
		List<Student> students = new ArrayList<Student>();
		while(set.next()) {
			Student stu = new Student();
			stu.setStudentNumber(set.getInt(1));
			stu.setStudentName(set.getString(2));
			students.add(stu);
		}
		return students;
	}

}
