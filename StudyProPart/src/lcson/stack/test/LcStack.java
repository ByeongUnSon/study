package lcson.stack.test;

/**
 * 
 * 
 * Comment Add
 * 
 * @author LcSon
 *
 */
public class LcStack {
		
	private Object[] stack;
	
	private int stackSize;
	private int top = -1;
		
	public LcStack(int stackSize) {
		this.stackSize = stackSize;
		stack = new Object[stackSize];
	}
	
	public void push(Object str) throws MyException {
		try {
			stack[++top] = str;
		} catch (ArrayIndexOutOfBoundsException ae) {
			throw new MyException("Stack Over Flow !! Error", ae);
		}
		
	}
	
	public Object pop() throws MyException {
		try {
			return stack[top--];
		} catch (ArrayIndexOutOfBoundsException ae) {
			throw new MyException("Stack Under Flow !! Error", ae);
		}
	} 
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == this.stackSize - 1;
	}
	
	public void show() {
		System.out.print("[");
		for (int i=0; i<=top; i++) {
				System.out.print(stack[i] + " ");
		}
		System.out.print("]");
	}

}
