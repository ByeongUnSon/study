package lcson.liststack.test;

public class ListStack {
	
	private StackNode top;		// 스택의 top
	
	/**
	 * Constructor
	 * 
	 * top Initialization
	 * 
	 */
	public ListStack() {
		top = null;		// top을 초기화 (공백 상태의 스택)
	}
	
	
	/**
	 * 스택의 top 에 자료 삽입
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
	 * 스택의 top으로부터 자료 읽기
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
	 * 스택이 공백 상태인 경우 true를 반환
	 * 
	 * @return
	 */
	protected boolean isEmpty() {
		return (top == null);
	}
}
