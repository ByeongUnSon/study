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
	 * ������ top�� �ڷ� ����
	 * 
	 * @param item
	 * @return
	 */
	public boolean push(Object item) {
		if (isFull()) {		// ������ ��ȭ ������ ���
			System.out.println("Stack is Full");
			return false;
		} else {
			stackArray[++top] = item;
			return true;
		}
	}
	
	/**
	 * ������ top���κ��� �ڷ� ����
	 * 
	 * @param item
	 * @return
	 */
	public boolean pop(Object item[]) {
		if (isEmpty()) {	// ������ ���� ������ ���
			System.out.println("Stack is Empty");
			return false;
		} else {
			item[0] = stackArray[top--];
			return true;
		}
	}
	
	/**
	 * ������ top���� �ڷ� �б�
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
