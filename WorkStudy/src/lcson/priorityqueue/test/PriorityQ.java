package lcson.priorityqueue.test;

public class PriorityQ {
	private int maxSize;					// ť �迭�� ũ��
	private long[] queueArray;
	private int nItems;					// ť�� �ڷ� ����
	Object tmp;
	
	public PriorityQ(int size) {	
		maxSize = size;						// ť �迭�� ũ�� ����
		queueArray = new long[maxSize];		// ť �迭 ����
		nItems = 0;							// nItems�� �ʱ�ȭ (���� ������ ť)
	}
	
	public boolean insert(long item) {
		int j;

		if (isEmpty())		// ť�� ���� ���¸� 0��° �ε����� �ڷ����
			queueArray[nItems++] = item;
	    else {
			for (j=nItems-1; j>=0; j--) {
				
				if (item > queueArray[j]) 			 // �����Ϸ��� �ڷᰡ �� ũ��
					queueArray[j+1] = queueArray[j]; // ���� �ڷḦ ��ĭ �ڷ� �̵�
				else	// �����Ϸ��� �ڷᰡ �۰ų� ������ �̵� ����
					break;
			
			}
			queueArray[j+1] = item;		// ���ο� �ڷ� ����				
			nItems++;					// nItems�� 1����
			
		}
		return true;
	}
	
	
	public boolean remove(long[] item) {
		if (isEmpty()) {
			System.out.println("Queue is Empty !!");
			return false;
		} else {
			item[0]	= queueArray[--nItems];		// nItems�� 1������ �ڷ�����
			return true;
		}
	}
	
	public boolean peekMin(long[] item) {	// ũ�Ⱑ ���� ���� �ڷ� �б�
		if (isEmpty()) {		// ť�� ���� ������ ���
			System.out.println("Queue is Empty !!");
			return false;
		} else {
			item[0] = queueArray[nItems-1];
			return true;
		}
	}
	
	protected boolean isFull() {
		return nItems == maxSize;
	}
	
	protected boolean isEmpty() {
		return nItems == 0;
	}
}
