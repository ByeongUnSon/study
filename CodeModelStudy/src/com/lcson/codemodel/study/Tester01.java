package com.lcson.codemodel.study;

import com.lcson.codemodel.gen.AbstractClass;

public class Tester01 extends AbstractClass {

	public Tester01() { }
	
	public Tester01(int value) {
		super(value);
	}

	public static void main(String[] args) {
		new Tester01().process(0);
	}

	@Override
	public void process(int input) {
		System.out.println("input value : " + input);		
	}

}
