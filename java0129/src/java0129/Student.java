package java0129;

public class Student {
	//속성을 변수로 생성
	private int num;
	private String name;
	private String gender;
	private int age;
	private int score;
	
	//데이터가 없는 경우에 사용할 생성자
	public Student() {
		super();
	}
	//데이터가 제공되는 경우에 사용할 생성자 - 테스트 할 때 데이터를 빠르게 입력해서 확인하기 위해서 생성
	public Student(int num, String name, String gender, int age, int score) {
		super();
		this.num = num;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.score = score;
	}
	
	//접근자 메소드
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	//데이터를 빠르게 확인하기 위한 메소드
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", gender=" + gender + ", age=" + age + ", score=" + score
				+ "]";
	}
}




