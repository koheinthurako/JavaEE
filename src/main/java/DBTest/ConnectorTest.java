package DBTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorTest {
	
	public void getConnection() throws ClassNotFoundException, SQLException {
//		mySQL နဲ့ java နဲ့ ချိတ်ပေးမယ့် Driver ကိုအရင်ဆုံးခေါ်ပေးရမယ် ချိတ်လိုက်တာကို မတွေ့တဲ့ error လည်းဖြစ်နိုင်လို့ throws ပေးရမယ်
		Class.forName("com.mysql.cj.jdbc.Driver");
//		database ကိုလှမ်းချိတ်ဖို့ java.sql interface package ထဲက Connection ကိုသုံးတယ်
//		interface ဆိုတော့ DriverManager.getConnection ကနေတစ်ဆင့််ခိုင်းရတယ် 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "ThetZawHein@10151099");
		System.out.println("DB connected!");
	}

}
