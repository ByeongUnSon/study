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
		lQueue.peek(removeItem);	// ť���� �ڷ��б�
		System.out.println(removeItem[0]);
		
		System.out.print("remove : ");
		while (lQueue.remove(removeItem)) {			// ť�� ���� ���°� �� ������ �ڷ� ����
			System.out.print(removeItem[0] + " ");
		}
		System.out.println("");
	}

}
