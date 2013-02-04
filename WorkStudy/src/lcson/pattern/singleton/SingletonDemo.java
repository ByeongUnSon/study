package lcson.pattern.singleton;

public class SingletonDemo {

	public static void main(String[] args) {
		SinglePoint p1, p2;
		
		// SinglePoint�� Singleton Ŭ�����̴�.
		// getInstance() �޼��带 ���� ������ ��ü�� ��ȯ�Ѵ�.
		// ���� �ΰ��� SinglePointŬ���� ��ü ���۷����� p1, p2�� ������ ��ü�� ����Ų��.
		p1 = SinglePoint.getInstance();
		p2 = SinglePoint.getInstance();
		
		p1.moveBy(7, 8);
		
		System.out.print("Points are ");
		p1.show();
		System.out.print(" and ");
		p2.show();
	}

}
