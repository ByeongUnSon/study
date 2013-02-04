package lcson.liststack.test;

public class ListStack {
	
	private StackNode top;		// ������ top
	
	/**
	 * Constructor
	 * 
	 * top Initialization
	 * 
	 */
	public ListStack() {
		top = null;		// top�� �ʱ�ȭ (���� ������ ����)
	}
	
	
	/**
	 * ������ top �� �ڷ� ����
	 * 
	 * @param item
	 */
	public void push(Object item) {
		StackNode newNode = new StackNode();
		newNode.stackItem = item;
		newNode.link = top;
		
		top = newNode;
	}
	
	public boolean pop(Object item[]) {
		if (isEmpty()) {
			System.out.println("Stack is Empty!!");
			return false;
		} else {
			item[0] = top.stackItem;
			top = top.link;
			
			return true;
		}
	}
	
	/**
	 * ������ top���κ��� �ڷ� �б�
	 * 
	 * @param item
	 * @return
	 */
	public boolean peek(Object item[]) {
		if (isEmpty()) {
			System.out.println("Stack is Empty!!");
			return false;
		} else {
			item[0]	= top.stackItem;
			return true;
		}
	}
	
	/**
	 * ������ ���� ������ ��� true�� ��ȯ
	 * 
	 * @return
	 */
	protected boolean isEmpty() {
		return (top == null);
	}
}
