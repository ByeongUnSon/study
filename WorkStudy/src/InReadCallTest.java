import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class InReadCallTest {

	public static void main(String[] args) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Scanner sc = new Scanner(System.in);
		Class<TestClass> testClassInfo = TestClass.class;
		Method[] methods = testClassInfo.getDeclaredMethods();
		TestClass obj = new TestClass();
		
		System.out.println(obj.getClass().getName() + "에 정의되어 있는 메서드 이름들");
		for (int i = 0; i < methods.length; i++) {
			System.out.println("methods[" + i + "] : " + methods[i].getName());
		}
		System.out.println("키보드로 부터 입력받아 원하는 메서드 호출하는 프로그램(종료는 exit 입력)");
		String input = "";
		
		while (true) {
			System.out.print("메서드 이름 입력 : ");
		
			input = sc.next();
			
			if (input.equals("methodOne"))
				methods[0].invoke(obj);
			if (input.equals("methodTwo"))
				methods[1].invoke(obj, 10);
			if (input.equals("methodThree"))
				methods[2].invoke(obj, 10, "Test String");
			if ( !(input.equals(methods[0].getName()) || input.equals(methods[1].getName()) || input.equals(methods[2].getName()) || input.equals("exit")) )
				System.out.println("TestClass에 정의되어 있는 적절한 메서드명을 입력하세요");
			if (input.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} 

		}

	}

}
