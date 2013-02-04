package lcson.arrayqueue.test;

public class LcQueue {
	private int maxSize;	// 큐 배열의 크기
	private Object[] queueArray;
	private int front;	// 큐의 front(head)
	private int rear;  // 큐의 rear(tail)
	
	public LcQueue(int maxSize) {
		this.maxSize = maxSize;
		queueArray = new Object[maxSize];
		front = 0;
		rear = -1;
	}
	
	public boolean insert(Object item) {	// 큐의 rear 에 자료삽입
		
		if (isFull()) {
			System.out.println("Queue is Full !!");
			return false;
		} else {
			queueArray[++rear] = item;	// rear 를 1증가 후 자료 삽입
			return true;
		}
	}
	
	public boolean remove(Object item[]) {
		if (isEmpty()) {
			System.out.println("Queue is Empty !!");
			return false;
		} else {
			item[0] = queueArray[front++];	// 자료 제거 후 front 를 1증가
			return true;
		}
	}
	
	public boolean peek(Object item[]) {
		if (isEmpty()) {
			System.out.println("Queue is Empty !!");	
			return false;
		} else {
			item[0] = queueArray[front];
			return true;
		}
	}
	
	protected boolean isFull() {
		return (rear == maxSize - 1);
	}
	
	protected boolean isEmpty() {			
		return (front == rear + 1);
	}
}
