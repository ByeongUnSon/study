package lcson.arrayqueue.test;

public class ArrayUsingQueue {

	public static void main(String[] args) {
		int queueSize = 5;
		LcQueue aQueue = new LcQueue(queueSize); // 새로운 큐 생성
		Object insertItem;
		System.out.print("insert : ");	
		for (int i=0; i<queueSize; i++) {
			insertItem = (i+1) * 10;
			aQueue.insert(insertItem);			 // 큐에 자료삽입 
			System.out.print(insertItem + " ");  // 삽입한 자료 출력
		}
		System.out.println("");
		
		Object[] removeItem = new Object[1];
		System.out.print("peek : ");
		aQueue.peek(removeItem);	// 큐에서 자료 읽기
		System.out.println(removeItem[0]);	// 읽은 자료 출력
		
		System.out.print("remove : ");
		while (aQueue.remove(removeItem)) { // 큐가 공백 상태가 될 때까지 큐에서 자료 제거
			System.out.print(removeItem[0] + " ");
		}
		System.out.println("");

	} // end main

} // end class ArrayUsingQueue
