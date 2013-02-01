package study01;

import java.io.IOException;
import org.apache.bcel.Constants;
import org.apache.bcel.generic.ALOAD;
import org.apache.bcel.generic.ASTORE;
import org.apache.bcel.generic.ArrayType;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.InstructionConstants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.LocalVariableGen;
import org.apache.bcel.generic.MethodGen;
import org.apache.bcel.generic.ObjectType;
import org.apache.bcel.generic.PUSH;
import org.apache.bcel.generic.Type;
/**
 * 
 * @author LcSon
 *		
 *	Below Example Java Class Generator
 *
 *  public class Test01 {
 *		public static void main(String[] args) {
 *			System.out.println("BCEL Test Start...");
 *			String strVar = "test variable String..";
 *			
 *			System.out.println("Str Value : " + strVar);
 *		}
 *  }
 *			
 */
public class BcelExample {

	public static void main(String[] args) {



		
		ClassGen cg = new ClassGen("Test01", "java.lang.Object","", Constants.ACC_PUBLIC | Constants.ACC_SUPER, null);
		
		ConstantPoolGen cp = cg.getConstantPool();
		InstructionList il = new InstructionList();
		
		// Method Generator
		MethodGen mg = new MethodGen(Constants.ACC_STATIC | Constants.ACC_PUBLIC,
				Type.VOID, new Type[] {
				new ArrayType(Type.STRING, 1)
		}, new String[]{ "args" }, "main", "Test01", il, cp);
		
		
		InstructionFactory factory = new InstructionFactory(cg);
		
		ObjectType p_stream = new ObjectType("java.io.PrintStream");
		
		il.append(factory.createFieldAccess("java.lang.System", "out" , p_stream, Constants.GETSTATIC));
		il.append(new PUSH(cp, "BCEL Test Start..."));
		il.append(factory.createInvoke("java.io.PrintStream", "println", Type.VOID, new Type[] { Type.STRING }, Constants.INVOKEVIRTUAL));
		
		
		// String class variable Generator
		LocalVariableGen lvgStr = mg.addLocalVariable("strVar", Type.STRING, null, null);
		int str = lvgStr.getIndex();
		il.append(new PUSH(cp, "test variable String"));
		lvgStr.setStart(il.append(new ASTORE(str)));
		
		// str Value + strVar
		il.append(factory.createFieldAccess("java.lang.System", "out", p_stream, Constants.GETSTATIC));
		il.append(factory.createNew(Type.STRINGBUFFER));
		il.append(InstructionConstants.DUP);
		il.append(new PUSH(cp,"Str Value : "));
		il.append(factory.createInvoke("java.lang.StringBuffer", "", Type.VOID, 
				new Type[] { Type.STRING }, Constants.INVOKESPECIAL));
		il.append(new ALOAD(str));
		il.append(factory.createInvoke("java.lang.StringBuffer", "append", Type.STRINGBUFFER, 
				new Type[] { Type.STRING }, Constants.INVOKEVIRTUAL));
		il.append(factory.createInvoke("java.lang.StringBuffer", "toString", Type.STRING, Type.NO_ARGS, Constants.INVOKEVIRTUAL));
		
		il.append(factory.createInvoke("java.io.PrintStream", "println", Type.VOID, 
				new Type[] { Type.STRING }, Constants.INVOKEVIRTUAL));
		il.append(InstructionConstants.RETURN);
		
		// return void
		il.append(InstructionConstants.RETURN);
		
		mg.setMaxStack();
		
		// Add Main Method At  Test01 Class
		cg.addMethod(mg.getMethod());
		
		il.dispose();
		
		// Construct
		cg.addEmptyConstructor(Constants.ACC_PUBLIC);
		
		// File Generator
		try {
			//cg.getJavaClass().dump("src/generator/" + cg.getClassName());
			//cg.getJavaClass().dump("build/" + cg.getClassName()+".class");
			cg.getJavaClass().dump("build/Test.class");
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}

		


		
	}

}
