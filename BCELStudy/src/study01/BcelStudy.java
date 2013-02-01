package study01;

import java.io.IOException;

import org.apache.bcel.Constants;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.FieldGen;
import org.apache.bcel.generic.InstructionConstants;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.Type;

import com.sun.codemodel.JCodeModel;

import util.JadUtil;

public class BcelStudy {

	public static void main(String[] args) throws Exception {
		
		
		ClassGen cg = new ClassGen("FieldTest06", "java.lang.Object","", Constants.ACC_PUBLIC | Constants.ACC_SUPER, null);
	
		
		ConstantPoolGen cp = cg.getConstantPool();
		InstructionList il = new InstructionList();
		
		FieldGen fg = new FieldGen(Constants.ACC_PRIVATE, Type.STRING, "code", cp);
	
		il.append(InstructionConstants.RETURN);

		cg.addField(fg.getField());

		il.dispose();
		
		// File Generator
		try {
			cg.getJavaClass().dump("build/"+cg.getClassName()+".class");
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
		
		JadUtil selfTest = new JadUtil();
		String CLASS_PATH = "d:/study/BCELStudy/build";
		String JAVA_PATH = "d:/study/BCELStudy/javaFolder";
		//String LOG_FILE = "d:/study/BCELStudy/jadutil_log";

		selfTest.setClassPath(CLASS_PATH);
		selfTest.setJavaPath(JAVA_PATH);
		//selfTest.setLogFile(LOG_FILE);

		selfTest.process();
	
		
		JCodeModel codeModel = new JCodeModel();
		
	
		
		
		System.out.println(cg.getJavaClass().getSource());
	}

}
