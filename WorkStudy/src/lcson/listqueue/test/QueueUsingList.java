package lcson.listqueue.test;

public class QueueUsingList {

	public static void main(String[] args) {
		QueueList lQueue = new QueueList();

		Object insertItem;
		System.out.print("insert : ");
		for (int i=0; i<3; i++) {
			insertItem = (i + 1) * 10;
			lQueue.insert(insertItem);
			System.out.print(insertItem + " ");
		}
		System.out.println("");

		Object[] removeItem = new Object[1];
		System.out.print("peek : ");
		lQueue.peek(removeItem);	// 큐에서 자료읽기
		System.out.println(removeItem[0]);
		
		System.out.print("remove : ");
		while (lQueue.remove(removeItem)) {			// 큐가 공백 상태가 될 때까지 자료 제거
			System.out.print(removeItem[0] + " ");
		}
		System.out.println("");
	}

}
