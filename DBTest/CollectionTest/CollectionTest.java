package CollectionTest;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest {

	public static void main(String[] args) {
		
		Test t = new Test("KoHein", 25, "Yangon", "JS");
		Test t2 = new Test("Thet", 26, "Japan", "Java");
		
		List<Test> list = new ArrayList<Test>();
//		list.add() ထဲမှာ primitive data type တွေမဟုတ်ပဲ object တစ်ခုကိုသွားထည့်ရင် မူရင်း class ထဲမှာ
//		declare ထားတဲ့ variable တွေအားလုံးကို list ထဲလာထည့်ပေးတယ် 
//		သို့သော် list ကို print ထုတ်တာပဲဖြစ်ဖြစ် list.get() ဆိုပြီးတော့ ထုတ်တာပဲဖြစ်ဖြစ် လုပ်ရင် Test.java ထဲက toString() method
//		ကနေပြန်ထုတ်ပေးရတဲ့အတွက် သူ့ထဲမှာ return ပြန်ထားတဲ့ ကောင်တွေပဲထွက်ချလာတယ်
		
		list.add(t);
		list.add(t2);
		System.out.println("List : " + list);
		System.out.println("List return test object : " + list.get(0));
		System.out.print("Object to String : ");
		System.out.print(list.get(0).getName());
		System.out.print(list.get(0).getAge());
		System.out.print(list.get(0).getLiveIn());
		System.out.println(list.get(0).getSkill());
		
	}

}
