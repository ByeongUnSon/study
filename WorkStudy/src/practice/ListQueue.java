package practice;

public class ListQueue {

	private QueueNode front;
	private QueueNode rear;

	/**
	 * Initialization Queue
	 * 
	 * Constructor
	 * 
	 */
	public ListQueue() {
		front = null;
		rear = null;
	}

	/**
	 * insert item (enQueue)
	 * 
	 * @param item
	 * @return
	 */
	public Object enQueue(Object item) {
		QueueNode newNode = new QueueNode();
		newNode.queueItem = item;
		newNode.link = null;

		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			rear.link = newNode;
			rear = newNode;
		}
		return item;
	}

	/**
	 * delete item (deQueue)
	 * 
	 * @return
	 * @throws MyException
	 */
	public Object deQueue() throws MyException {

		Object item = null;
		try {
			item = front.queueItem;
			front = front.link;
		} catch (NullPointerException npe) {
			throw new MyException("NullPointer Error !! ", npe);
		}
		return item;

	}

	/**
	 * Get current item
	 * 
	 * @return
	 */
	public Object peek() {
		if (isEmpty()) {
			return "Queue is Empty!!";
		} else {
			return front.queueItem;
		}
	}

	protected boolean isEmpty() {
		return front == null;
	}
}
