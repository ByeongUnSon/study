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
		
		System.out.println(obj.getClass().getName() + "�� ���ǵǾ� �ִ� �޼��� �̸���");
		for (int i = 0; i < methods.length; i++) {
			System.out.println("methods[" + i + "] : " + methods[i].getName());
		}
		System.out.println("Ű����� ���� �Է¹޾� ���ϴ� �޼��� ȣ���ϴ� ���α׷�(����� exit �Է�)");
		String input = "";
		
		while (true) {
			System.out.print("�޼��� �̸� �Է� : ");
		
			input = sc.next();
			
			if (input.equals("methodOne"))
				methods[0].invoke(obj);
			if (input.equals("methodTwo"))
				methods[1].invoke(obj, 10);
			if (input.equals("methodThree"))
				methods[2].invoke(obj, 10, "Test String");
			if ( !(input.equals(methods[0].getName()) || input.equals(methods[1].getName()) || input.equals(methods[2].getName()) || input.equals("exit")) )
				System.out.println("TestClass�� ���ǵǾ� �ִ� ������ �޼������ �Է��ϼ���");
			if (input.equals("exit")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} 

		}

	}

}
