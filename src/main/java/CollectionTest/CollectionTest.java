package CollectionTest;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest {

	public static void main(String[] args) {
		
		Test t = new Test("KoHein", 25, "Yangon", "JS");
		Test t2 = new Test("Thet", 26, "Japan", "Java");
		
		List<Test> list = new ArrayList<Test>();

		list.add(t);
		list.add(t2);
		System.out.println("List : " + list);
		System.out.println("List return test object : " + list.get(0));
		System.out.print(list.get(0).getName());
		System.out.print(list.get(0).getAge());
		System.out.println(list.get(0).getLiveIn());
		
	}

}
