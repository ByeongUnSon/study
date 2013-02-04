
public class LStackTest {

	
	public static void main(String[] args) {
		LStack stack = new LStack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.show();
		System.out.println("peek" + stack.peek());
		
	}

}
