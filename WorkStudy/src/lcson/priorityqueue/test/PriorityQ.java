package lcson.priorityqueue.test;

public class PriorityQ {
	private int maxSize;					// 큐 배열의 크기
	private long[] queueArray;
	private int nItems;					// 큐의 자료 개수
	Object tmp;
	
	public PriorityQ(int size) {	
		maxSize = size;						// 큐 배열의 크기 설정
		queueArray = new long[maxSize];		// 큐 배열 생성
		nItems = 0;							// nItems를 초기화 (공백 상태의 큐)
	}
	
	public boolean insert(long item) {
		int j;

		if (isEmpty())		// 큐가 공백 상태면 0번째 인덱스에 자료삽입
			queueArray[nItems++] = item;
	    else {
			for (j=nItems-1; j>=0; j--) {
				
				if (item > queueArray[j]) 			 // 삽입하려는 자료가 더 크면
					queueArray[j+1] = queueArray[j]; // 기존 자료를 한칸 뒤로 이동
				else	// 삽입하려는 자료가 작거나 같으면 이동 종료
					break;
			
			}
			queueArray[j+1] = item;		// 새로운 자료 삽입				
			nItems++;					// nItems를 1증가
			
		}
		return true;
	}
	
	
	public boolean remove(long[] item) {
		if (isEmpty()) {
			System.out.println("Queue is Empty !!");
			return false;
		} else {
			item[0]	= queueArray[--nItems];		// nItems를 1감소후 자료제거
			return true;
		}
	}
	
	public boolean peekMin(long[] item) {	// 크기가 가장 작은 자료 읽기
		if (isEmpty()) {		// 큐가 공백 상태인 경우
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
