package practice;

public class ListStackTest {

	public static void main(String[] args) throws MyException {
		ListStack stack = new ListStack();
		System.out.print("push : [ ");
		System.out.print(stack.push(123123) + " ");
		System.out.print(stack.push("æ»≥Á«œººø‰") + " ");
		System.out.print(stack.push("abc"));
		System.out.println(" ] ");
		System.out.print("pop : [ ");
		System.out.print(stack.pop() + " ");
		System.out.print(stack.pop() + " ");
		System.out.print(stack.pop());
		System.out.println(" ] ");
		//System.out.print(stack.pop());
		System.out.print(stack.push("test"));
	}

}
