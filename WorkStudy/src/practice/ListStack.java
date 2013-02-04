package practice;

public class ListStack {
	
	private StackNode top;		// top of stack
	
	/**
	 * Constructor
	 * 
	 * Initialization top 
	 * 
	 */
	public ListStack() {
		top = null;
	}
	
	/**
	 * push
	 * 
	 * @param item
	 * @return
	 */
	public Object push(Object item) {
		StackNode newNode = new StackNode();
		newNode.stackItem = item;
		newNode.link = top;

		top = newNode;
		return item;
	}
	
	/**
	 * pop
	 * 
	 * @return
	 * @throws MyException 
	 */
	public Object pop() throws MyException {
		Object item = null;	
		try {
			item = top.stackItem;
			top = top.link;
		} catch (NullPointerException npe) {
			throw new MyException("NullPointer Error !!", npe);
		}
		return item;
	}
	
	/**
	 * 
	 * get current value 
	 * 
	 * @return
	 */
	public Object peek() {
		return top.stackItem;
	}
	
	/**
	 * Is top Empty ?
	 * 
	 * @return
	 */
	protected boolean isEmpty() {
		return top == null;
	}
}
