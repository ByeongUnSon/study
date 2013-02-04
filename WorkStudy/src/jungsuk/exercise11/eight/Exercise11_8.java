package jungsuk.exercise11.eight;

import java.util.*;

/**
 * 문제11-8의 Student 클래스에 반등수(classRank)를 저장하기 위한 인스턴스변수를 추가하였다. 반등수를 계산하고 반과 반등수로
 * 오름차순 정렬하여 결과를 출력하시오. (1)~(2)에 알맞은 코드를 넣어 완성하시오.
 * 
 * @author Administrator
 * 
 */
class Student implements Comparable<Object> {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total;
	int schoolRank; // 전교등수
	int classRank; // 반등수

	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor + eng + math;
	}

	int getTotal() {
		return total;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public int compareTo(Object o) {
		if (o instanceof Student) {
			Student tmp = (Student) o;
			return tmp.total - this.total;
		} else {
			return -1;
		}
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math
				+ "," + getAverage() + "," + schoolRank + "," + classRank // 새로추가
		;
	}
} // class Student

class ClassTotalComparator implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;

		int result = s1.ban - s2.ban;
		
		if (result == 0)
			result = s1.total - s2.total;
		
		return result;
	}
}

public class Exercise11_8 {

	public static void calculateClassRank(List<Object> list) {
		// 먼저 반별 총점기준 내림차순으로 정렬한다.
		Collections.sort(list, new ClassTotalComparator());
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		/*
		 * (2) 아래의 로직에 맞게 코드를 작성하시오. 1. 반복문을 이용해서 list 에 저장된 Student 객체를 하나씩 읽는다.
		 * 1.1 반이 달라지면,(ban 과 prevBan 이 다르면) 이전 등수(prevRank)와 이전 총점(prevTotal)을
		 * 초기화 한다. 1.2 총점(total)이 이전총점(prevTotal)과 같으면 이전 등수(prevRank)를
		 * 등수(schoolRank)로 한다. 1.3 총점이 서로 다르면, 등수(schoolRank)의 값을 알맞게 계산해서 저장한다.
		 * 이전에 동점자였다면, 그 다음 등수는 동점자의 수를 고려해야한다. (실행결과 참고) 1.4 현재 반과 총점과 등수를 이전
		 * 반(prevBan), 이전 총점(prevTotal), 이전 등수(prevRank)에 저장한다.
		 */
		for (int i = 0, n = 0; i < length; i++, n++) {
			Student s = (Student) list.get(i);

			if (s.ban != prevBan) {
				prevRank = -1;
				prevTotal = -1;
				n = 0;
			} else if (s.total == prevTotal) {
				s.classRank = prevRank;
			} else {
				s.classRank = n + 1;
			}
			prevBan = s.ban;
			prevTotal = s.total;
			prevRank = s.classRank;
		}

	} // public static void calculateClassRank(List list) {

	public static void calculateSchoolRank(List list) {
		Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬한다.

		int prevRank = -1; // 이전 전교등수
		int prevTotal = -1; // 이전 총점
		int length = list.size();

		for (int i = 0; i < length; i++) {
			Student s = (Student) list.get(i);
			if (s.total == prevTotal) {
				s.schoolRank = prevRank;
			} else {
				s.schoolRank = i + 1;
			}
			prevRank = s.schoolRank;
			prevTotal = s.total;
		} // for
	}

	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<Object>();
		
		list.add(new Student("이자바", 2, 1, 70, 90, 70));
		list.add(new Student("안자바", 2, 2, 60, 100, 80));
		list.add(new Student("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student("김자바", 1, 2, 80, 80, 90));

		calculateSchoolRank(list);
		calculateClassRank(list);
		
		Iterator<Object> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}

}
