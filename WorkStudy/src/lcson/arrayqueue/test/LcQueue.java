package lcson.arrayqueue.test;

public class LcQueue {
	private int maxSize;	// ť �迭�� ũ��
	private Object[] queueArray;
	private int front;	// ť�� front(head)
	private int rear;  // ť�� rear(tail)
	
	public LcQueue(int maxSize) {
		this.maxSize = maxSize;
		queueArray = new Object[maxSize];
		front = 0;
		rear = -1;
	}
	
	public boolean insert(Object item) {	// ť�� rear �� �ڷ����
		
		if (isFull()) {
			System.out.println("Queue is Full !!");
			return false;
		} else {
			queueArray[++rear] = item;	// rear �� 1���� �� �ڷ� ����
			return true;
		}
	}
	
	public boolean remove(Object item[]) {
		if (isEmpty()) {
			System.out.println("Queue is Empty !!");
			return false;
		} else {
			item[0] = queueArray[front++];	// �ڷ� ���� �� front �� 1����
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
