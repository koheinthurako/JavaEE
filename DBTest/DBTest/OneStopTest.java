package DBTest;

import java.sql.SQLException;

public class OneStopTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		method ကိုခေါ်လိုက်တော့ throws ထားတာတွေရှိလို့ ခေါ်လိုက်တဲ့ main method မှာလည်း ပြန် throw ပေးရတယ်
		ConnectorTest.getConnection();
	}

}
