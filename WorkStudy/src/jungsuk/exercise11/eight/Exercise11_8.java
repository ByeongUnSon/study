package jungsuk.exercise11.eight;

import java.util.*;

/**
 * ����11-8�� Student Ŭ������ �ݵ��(classRank)�� �����ϱ� ���� �ν��Ͻ������� �߰��Ͽ���. �ݵ���� ����ϰ� �ݰ� �ݵ����
 * �������� �����Ͽ� ����� ����Ͻÿ�. (1)~(2)�� �˸��� �ڵ带 �־� �ϼ��Ͻÿ�.
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
	int schoolRank; // �������
	int classRank; // �ݵ��

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
				+ "," + getAverage() + "," + schoolRank + "," + classRank // �����߰�
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
		// ���� �ݺ� �������� ������������ �����Ѵ�.
		Collections.sort(list, new ClassTotalComparator());
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		/*
		 * (2) �Ʒ��� ������ �°� �ڵ带 �ۼ��Ͻÿ�. 1. �ݺ����� �̿��ؼ� list �� ����� Student ��ü�� �ϳ��� �д´�.
		 * 1.1 ���� �޶�����,(ban �� prevBan �� �ٸ���) ���� ���(prevRank)�� ���� ����(prevTotal)��
		 * �ʱ�ȭ �Ѵ�. 1.2 ����(total)�� ��������(prevTotal)�� ������ ���� ���(prevRank)��
		 * ���(schoolRank)�� �Ѵ�. 1.3 ������ ���� �ٸ���, ���(schoolRank)�� ���� �˸°� ����ؼ� �����Ѵ�.
		 * ������ �����ڿ��ٸ�, �� ���� ����� �������� ���� ����ؾ��Ѵ�. (������ ����) 1.4 ���� �ݰ� ������ ����� ����
		 * ��(prevBan), ���� ����(prevTotal), ���� ���(prevRank)�� �����Ѵ�.
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
		Collections.sort(list); // ���� list�� �������� ������������ �����Ѵ�.

		int prevRank = -1; // ���� �������
		int prevTotal = -1; // ���� ����
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
		
		list.add(new Student("���ڹ�", 2, 1, 70, 90, 70));
		list.add(new Student("���ڹ�", 2, 2, 60, 100, 80));
		list.add(new Student("ȫ�浿", 1, 3, 100, 100, 100));
		list.add(new Student("���ü�", 1, 1, 90, 70, 80));
		list.add(new Student("���ڹ�", 1, 2, 80, 80, 90));

		calculateSchoolRank(list);
		calculateClassRank(list);
		
		Iterator<Object> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}

}
