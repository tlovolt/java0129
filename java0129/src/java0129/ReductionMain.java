package java0129;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class ReductionMain {

	public static void main(String[] args) {
		//샘플 데이터 작성
		Student student1 = new Student(1, "김좌진", "남", 28, 93);
		Student student2 = new Student(2, "유관순", "여", 19, 89);
		Student student3 = new Student(3, "김구", "남", 38, 95);
		Student student4 = new Student(4, "안중근", "남", 29, 100);
		Student student5 = new Student(5, "남자현", "여", 25, 97);
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		list.add(student4);
		list.add(student5);
		
		//distinct - 중복을 제거해주는 메소드
		String [] ar = {"데니스 리치히", "귀도 반 로섬", "제임스 고슬링", "데니스 리치히"};
		Stream<String> arStream = Arrays.stream(ar);
		arStream.distinct().forEach(System.out::println);
		
		System.out.println();
		//filter - 조건에 맞는 데이터만 추출하는 중간 연산
		//filter에는 매개변수 1개를 갖고 boolean을 리턴하는 람다식을 대입
		Stream <Student> stream = list.stream();
		//score가 90 보다 큰 데이터만 추출해서 출력
		//stream.filter((student)->{return student.getScore() > 90;}).forEach(System.out::println);
		
		//gender 가 여인 데이터만 추출해서 출력
		stream.filter((student)->{return student.getGender().equals("여");}).forEach(System.out::println);

		System.out.println();
		//map()은 데이터를 변환할 때 사용하는 메소드
		//숫자 -> 문자열, 문자열 -> 숫자, 날짜 -> 문자열, 인스턴스 -> 기본형
		//Student를 score로 변환
		stream = list.stream(); //스트림은 한 번 사용하면 소멸되기 때문에 다시 사용할 때는 새로 생성해야 합니다.
		//어떤 메소드를 수행만 하는 경우에는 클래스이름::메소드이름 만 입력해도 됩니다.
		//stream.mapToInt((student)->{return student.getScore();}).forEach(System.out::println);
		stream.mapToInt(Student::getScore).forEach(System.out::println);
		
		System.out.println();
		//데이터 정렬은 sorted 메소드를 이용
		//각 요소가 크기 비교가 가능하다면 바로 오름차순 정렬을 수행
		//요소가 크기 비교가 불가능하다면 크기 비교가 가능한 메소드를 대입해야 합니다.
		//크기 비교가 가능한 데이터는 속성을 하나만 가진 데이터들입니다.
		//기본 자료형, 문자열, 날짜 정도가 하나의 데이터만을 가진 자료형입니다.
		
		//String은 크기 비교가 가능하기 때문에 바로 오름차순 정렬
		arStream = Arrays.stream(ar);
		arStream.sorted().forEach(System.out::println);
		
		System.out.println();
		stream = list.stream();
		//Student는 여러 개의 항목을 소유하고 있기 때문에 어떤 항목으로 크기 비교를 할 지 알지 못하기 때문에 예외가 발생
		//stream.sorted().forEach(System.out::println);
		
		//크기 비교하는 메소드를 만들어서 정렬
		//크기 비교를 할 때는 2개의 매개변수를 가지고 정수를 리턴하는 메소드를 만들면 됩니다.
		//양수를 리턴하면 앞의 데이터가 크다고 간주하고 0이면 같다고 음수이면 뒤의 데이터가 크다고 간주
		
		//숫자 데이터를 이용해서 비교하는 경우 - 오름차순
		//stream.sorted((a, b) -> {return a.getScore() - b.getScore();}).forEach(System.out::println);
		
		//문자열인 경우는 compareTo 를 이용 - 앞 뒤 순서를 변경하면 내림차순
		stream.sorted((a, b) -> {return b.getName().compareTo(a.getName());}).forEach(System.out::println);
	}

}








