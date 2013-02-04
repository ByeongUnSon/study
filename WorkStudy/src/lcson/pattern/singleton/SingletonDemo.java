package lcson.pattern.singleton;

public class SingletonDemo {

	public static void main(String[] args) {
		SinglePoint p1, p2;
		
		// SinglePoint는 Singleton 클래스이다.
		// getInstance() 메서드를 통해 유일한 객체를 반환한다.
		// 따라서 두개의 SinglePoint클래스 객체 레퍼런스인 p1, p2는 동일한 객체를 가리킨다.
		p1 = SinglePoint.getInstance();
		p2 = SinglePoint.getInstance();
		
		p1.moveBy(7, 8);
		
		System.out.print("Points are ");
		p1.show();
		System.out.print(" and ");
		p2.show();
	}

}
