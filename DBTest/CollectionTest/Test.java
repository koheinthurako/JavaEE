package CollectionTest;

public class Test {

	private String name;
	private int age;
	private String liveIn;
	private String skill;
	
	public Test(String name, int age, String liveIn, String skill) {
		this.name = name;
		this.age = age;
		this.liveIn = liveIn;
		this.skill = skill;
	};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLiveIn() {
		return liveIn;
	}

	public void setLiveIn(String liveIn) {
		this.liveIn = liveIn;
	}

	@Override
	public String toString() {
		return String.format("%s\t%d\t%s", name, age, liveIn);
	}
	
}
