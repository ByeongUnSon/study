package lcson.listqueue.test;

public class QueueList {
	private QueueNode front;
	private QueueNode rear;
	
	public QueueList() {
		front = null;
		rear = null;
	}
	
	public void insert(Object item) {
		QueueNode newNode = new QueueNode();
		newNode.queueItem = item;
		newNode.link = null;
		
		if (isEmpty()) {
			rear = newNode;
			front = newNode;
		} else {
			rear.link = newNode;
			rear = newNode;
		}
		
	}
	
	public boolean remove(Object[] item) {
		if (isEmpty()) {
			System.out.println("Queue is Empty !!");
			return false;
		} else {
			item[0] = front.queueItem;
			front = front.link;
			if (front == null)
				rear = null;
			return true;
		}
	}
	
	public boolean peek(Object[] item) {
		if (isEmpty()) {
			System.out.println("Queue is Empty !!");
			return false;
		} else {
			item[0] = front.queueItem;
			return true;
		}
	}
	
	protected boolean isEmpty() {		// 큐가 공백 상태이면 true 를 반환
		return front == null;
	}
}
