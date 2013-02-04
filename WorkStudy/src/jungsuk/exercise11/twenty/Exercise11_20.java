package jungsuk.exercise11.twenty;

import java.util.*;

class Exercise11_20 {
	static ArrayList<Object> record = new ArrayList<Object>(); // ���������͸� ������ ����
	static Scanner s = new Scanner(System.in);

	public static void main(String args[]) {
		while (true) {
			switch (displayMenu()) {
			case 1:
				inputRecord();
				break;
			case 2:
				displayRecord();
				break;
			case 3:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
		} // while(true)
	}

	// menu�� �����ִ� �޼���
	static int displayMenu() {
		System.out
				.println("**************************************************");
		System.out.println("* ���� ���� ���α׷� *");
		System.out
				.println("**************************************************");
		System.out.println();
		System.out.println(" 1. �л����� �Է��ϱ� ");
		System.out.println();
		System.out.println(" 2. �л����� ����");
		System.out.println();
		System.out.println(" 3. ���α׷� ���� ");
		System.out.println();
		System.out.print("���ϴ� �޴��� �����ϼ���.(1~3) : ");
		int menu = 0;
		/*
		 * (1) �Ʒ��� ������ �°� �ڵ带 �ۼ��Ͻÿ�. 1. ȭ�����κ��� �޴��� �Է¹޴´�. �޴��� ���� 1~3������ ���̾�� �Ѵ�.
		 * 2. 1~3������ ���� �Է¹��� ������, �޴��� ������ �߸��Ǿ����� �˷��ְ� �ٽ� �Է¹޴´�.(��ȿ�� ���� �Է¹��� ������
		 * �ݺ��ؼ� �Է¹޴´�.)
		 */

		do {
			try {
			menu = s.nextInt();
			if (menu >=1 && menu <=3)
				break;
			else 
				throw new Exception();
			} catch (Exception e) {
				System.out.println("�޴��� ������ �߸��Ǿ����ϴ�. �ٽ� �Է����ּ���..");
				System.out.print("���ϴ� �޴��� �����ϼ���.(1~3) : ");
			}
		} while (true);

		return menu;
	} // public static int displayMenu(){
		// �����͸� �Է¹޴� �޼���

	static void inputRecord() {
		System.out.println("1. �л����� �Է��ϱ�");
		System.out.println("�̸�,��,��ȣ,�����,�����,���м���'�� ������ ������� �Է��ϼ���.");
		System.out.println("�Է��� ��ġ���� q�� �Է��ϼ���. ����ȭ������ ���ư��ϴ�.");
		while (true) {
			System.out.print(">>");
			/*
			 * (2) �Ʒ��� ������ �°� �ڵ带 �ۼ��Ͻÿ�. 1. Scanner�� �̿��ؼ� ȭ������ ���� �����͸�
			 * �Է¹޴´�.(','�� �����ڷ�) 2. �Է¹��� ���� q �Ǵ� Q�̸� �޼��带 �����ϰ�, �׷��� ������ �Է¹��� ������
			 * Student�ν��Ͻ��� �����ϰ� record�� �߰��Ѵ�. 3. �Է¹��� �����Ϳ��� ���ܰ� �߻��ϸ�,
			 * "�Է¿����Դϴ�."�� �����ְ� �ٽ� �Է¹޴´�. 4. q �Ǵ� Q�� �Էµ� ������ 2~3�� �۾��� �ݺ��Ѵ�.
			 */
			String input = s.next().trim();
			if (input.equalsIgnoreCase("q"))
				return;
			else {
				try {
					if (!input.equalsIgnoreCase("q")) {
						Scanner sc = new Scanner(input).useDelimiter(",");				
						record.add(new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
						System.out.println("�Է��� �Ǿ����ϴ�. �Է��� ��ġ���� q�� �Է��ϼ���.");
					} else {
						return;
					}
				} catch (Exception e) { 
					System.out.println("�Է¿����Դϴ�.");
				}
			}
			
		} // end of while
	} // public static void inputRecord() {
		// ������ ����� �����ִ� �޼���

	static void displayRecord() {
		int koreanTotal = 0;
		int englishTotal = 0;
		int mathTotal = 0;
		int total = 0;
		int length = record.size();
		if (length > 0) {
			System.out.println();
			System.out.println("�̸� �� ��ȣ ���� ���� ���� ���� ��� ������� �ݵ��");
			System.out
					.println("====================================================");
			for (int i = 0; i < length; i++) {
				Student student = (Student) record.get(i);
				System.out.println(student);
				koreanTotal += student.kor;
				mathTotal += student.math;
				englishTotal += student.eng;
				total += student.total;
			}
			System.out
					.println("====================================================");
			System.out.println("����: " + koreanTotal + " " + englishTotal + " "
					+ mathTotal + " " + total);
			System.out.println();
		} else {
			System.out
					.println("====================================================");
			System.out.println(" �����Ͱ� �����ϴ�.");
			System.out
					.println("====================================================");
		}
	} // static void displayRecord() {
}

class Student implements Comparable<Object> {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total;
	int schoolRank;
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
				+ "," + getTotal() + "," + getAverage() + "," + schoolRank
				+ "," + classRank;
	}
} // class Student