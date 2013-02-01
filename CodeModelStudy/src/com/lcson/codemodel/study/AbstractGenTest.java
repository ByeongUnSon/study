package com.lcson.codemodel.study;

import java.io.File;
import java.io.IOException;

import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMod;

public class AbstractGenTest {

	public static void main(String[] args) throws JClassAlreadyExistsException, IOException {
		JCodeModel codeModel = new JCodeModel();
	
		// JDefinedClass voClass = codeModel._class("com.lcson.codemodel.gen.AbstractClass", new ClassType("abstract"));
		JDefinedClass voClass  = codeModel._class(JMod.ABSTRACT | JMod.PUBLIC, "com.lcson.codemodel.gen.AbstractClass", ClassType.CLASS);

		//ClassType ABSTRACT = new ClassType("abstract");
		//JDefinedClass voClass = codeModel._class("com.lcson.codemodel.gen.AbstractClass");
		voClass.field(JMod.PRIVATE , Integer.TYPE , "code");
		

		voClass.isAbstract();

		
		File file = new File("./src");
		file.mkdir();
		codeModel.build(file);
		
	}

}
