
public class LStack {
	
	private Object[] stack;
	private int stackSize;
	private int top;
	
	public LStack(int stackSize) {
		this.stackSize = stackSize;
		top = -1;
		stack = new Object[stackSize];
	}
	
	public Object[] getObject() {
		return stack;
	}
	
	public boolean push(Object str) {
		if (isFull()) {
			System.out.println("Stack is Full !!");
			return false;
		} else {
			stack[++top] = str;
			return true;
		}
	}
	
	public Object peek() {
		return stack[top];
	}
	
	public Object pop() {
	
		return stack[top--];
	}
	
	public void show() {
		System.out.print("[ ");
		for (int i=0; i<=top; i++) {
			System.out.print(stack[i] + " ");
		}
		System.out.println(" ]");
	}
	
	protected boolean isFull() {
		return top == this.stackSize -1;
	}
	
	protected boolean isEmpty() {
		return top == -1;
	}
}
