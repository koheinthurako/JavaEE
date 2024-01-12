package entityServiceTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entityTest.Student;

public interface studentServiceTest {
	
//	service interface ထဲမှာကတော့ database ကို အလုပ်လုပ်ဖို့ query တွေအတွက် ဘုံ java method တွေရေးလေ့ရှိတယ်
//	သို့သော် အလုပ်လုပ်ဖို့ method တွေကိုတော့ serviceImplementation ထဲမှာပဲ override ရေးတယ်
//	get() method ကိုခေါ်လိုက်တာနဲ့ student table တွေထဲက student တွေကို console မှာရိုက်ပြချင်တယ်ဆိုရင် return type က Object အနေနဲ့ပြန်မယ်
	public List<Student> get(Connection con) throws SQLException;
	

}
