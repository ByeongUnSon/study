package lcson.arrayqueue.test;

public class ArrayUsingQueue {

	public static void main(String[] args) {
		int queueSize = 5;
		LcQueue aQueue = new LcQueue(queueSize); // ���ο� ť ����
		Object insertItem;
		System.out.print("insert : ");	
		for (int i=0; i<queueSize; i++) {
			insertItem = (i+1) * 10;
			aQueue.insert(insertItem);			 // ť�� �ڷ���� 
			System.out.print(insertItem + " ");  // ������ �ڷ� ���
		}
		System.out.println("");
		
		Object[] removeItem = new Object[1];
		System.out.print("peek : ");
		aQueue.peek(removeItem);	// ť���� �ڷ� �б�
		System.out.println(removeItem[0]);	// ���� �ڷ� ���
		
		System.out.print("remove : ");
		while (aQueue.remove(removeItem)) { // ť�� ���� ���°� �� ������ ť���� �ڷ� ����
			System.out.print(removeItem[0] + " ");
		}
		System.out.println("");

	} // end main

} // end class ArrayUsingQueue
