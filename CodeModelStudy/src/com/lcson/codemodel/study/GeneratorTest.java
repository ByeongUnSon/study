package com.lcson.codemodel.study;

import java.io.File;
import java.io.IOException;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JVar;

public class GeneratorTest {


	public static void main(String[] args) throws JClassAlreadyExistsException, IOException {
		JCodeModel codeModel = new JCodeModel();
		
		JDefinedClass voClass = codeModel._class("com.lcson.codemodel.gen.GeneratorClass");
		
		JFieldVar field = voClass.field(JMod.PRIVATE, String.class, "code01");
		
		// Getter
		JMethod method = voClass.method(JMod.PUBLIC, String.class, "get" + 
				field.name().substring(0, 1).toUpperCase() + field.name().substring(1));
		
		method.body()._return(JExpr._this().ref(field.name()));
		
		// Setter
		method = voClass.method(JMod.PUBLIC, void.class, "set" + 
				field.name().substring(0, 1).toUpperCase() + field.name().substring(1));
		JVar setterParam = method.param(String.class, field.name());
		
		method.body().assign(JExpr._this().ref(field.name()), setterParam);
		
		File file = new File("./src");
		file.mkdir();
		codeModel.build(file);
		
	}

}
