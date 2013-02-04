package lcson.priorityqueue.test;

public class PriorityQTest {

	public static void main(String[] args) {
		
		int queueSize = 5;
		PriorityQ pQueue = new PriorityQ(queueSize);
		
		// 큐에 자료 삽입
		System.out.print("insert : ");
		pQueue.insert(30);
		pQueue.insert(50);
		pQueue.insert(10);
		pQueue.insert(40);
		pQueue.insert(20);
		System.out.println("30 40 10 40 20");
		
		long[] removeItem = new long[1];
		System.out.print("peek minimum : ");
		pQueue.peekMin(removeItem);			// 큐에서 가장 작은 자료 읽기
		System.out.println(removeItem[0]);
		
		System.out.print("remove : ");
		
		while (pQueue.remove(removeItem)) {		// 큐가 공백 상태가 될 때까지 자료 제거
			System.out.print(removeItem[0] + " ");
		}
		
		System.out.println("");
	}

}
