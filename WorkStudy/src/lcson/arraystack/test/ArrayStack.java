package lcson.arraystack.test;

public class ArrayStack {
	private int maxSize;
	private Object[] stackArray;
	private int top;
	
	public ArrayStack(int size) {
		maxSize = size;
		stackArray = new Object[maxSize];
		top = -1;
	}
	
	/**
	 * 스택의 top에 자료 삽입
	 * 
	 * @param item
	 * @return
	 */
	public boolean push(Object item) {
		if (isFull()) {		// 스택이 포화 상태인 경우
			System.out.println("Stack is Full");
			return false;
		} else {
			stackArray[++top] = item;
			return true;
		}
	}
	
	/**
	 * 스택의 top으로부터 자료 제거
	 * 
	 * @param item
	 * @return
	 */
	public boolean pop(Object item[]) {
		if (isEmpty()) {	// 스택이 공백 상태인 경우
			System.out.println("Stack is Empty");
			return false;
		} else {
			item[0] = stackArray[top--];
			return true;
		}
	}
	
	/**
	 * 스택의 top에서 자료 읽기
	 * 
	 * @param item
	 * @return
	 */
	public boolean peek(Object item[]) {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
			return false;
		} else {
			item[0] = stackArray[top];
			return true;
		}
	}
	
	protected boolean isFull() {
		return (top == maxSize -1);
	}
	
	protected boolean isEmpty() {
		return (top == -1);
	}
	
}
