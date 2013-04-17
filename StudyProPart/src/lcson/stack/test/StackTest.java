package lcson.stack.test;

public class StackTest {

	public static void main(String[] args) throws MyException {
		LcStack stack = new LcStack(5);
		
		stack.push(123123123);
		stack.show();
		stack.push(1231231);
		stack.show();
		stack.pop();
		stack.show();	
	}

}
