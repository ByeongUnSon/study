package com.ick.invocation.test;

public class TestClass {

	public void methodOne() {
		System.out.println("methodOne is called");
	}
	public void methodTwo(int i) {
		System.out.println("methodTwo is called " + Integer.toString(i));
	}
	public void methodThree(int i, String str) {
		System.out.println("methodThree is called " + Integer.toString(i) + " " + str);
	}
}
