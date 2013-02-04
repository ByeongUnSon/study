package com.ick.invocation.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DynamicMethodTest {

	public static void main(String[] args) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {

		Class<TestClass> testClassInfo = TestClass.class;

		Method[] methods = testClassInfo.getDeclaredMethods();

		TestClass obj = new TestClass();
		
		for (Method method : methods) {

			String methodName = method.getName();
			System.out.println("------------------------------------------");
			System.out.println("Method Name : " + methodName);
			System.out.println("Method Name with param : " + method.toString());
			System.out.println("Method Param No : "
					+ method.getParameterTypes().length);

			if (methodName.equals("methodOne"))
				method.invoke(obj);

			if (methodName.equals("methodTwo"))
				method.invoke(obj, 10);

			if (methodName.equals("methodThree"))
				method.invoke(obj, 10, "Test String");

		}
	

	}

}
