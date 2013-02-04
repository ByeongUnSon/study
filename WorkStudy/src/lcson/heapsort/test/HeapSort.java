package lcson.heapsort.test;
/**
 * 크기가 작을수록 우선순위가 높은것으로 간주한다.
 * 
 * @author Administrator
 *
 */
public class HeapSort {
	private int arraySize;		// 힙을 구성하는 배열의 크기
	private int curSize;		// 힙이 현재 갖고 있는 자료 개수
	private Node[] bHeap;
	
	public HeapSort(int arraySize) {
		this.arraySize = arraySize;
		bHeap = new Node[arraySize];
		curSize = 0;
	}
	
	public int getParent(int child) {
		if ((child % 2) == 1)	// 홀수 이므로 왼쪽 자식
			 return (int)((child - 1) / 2);
		else	// 짝수 이므로 오른쪽 자식
			return (int)((child - 2) / 2);
	}
	
	public int getLeftChild(int parent) {
		return (parent * 2) + 1;
	}
	
	public int getRightChild(int parent) {
		return (parent * 2) + 2;
	}
	
	public int insert(int data) {
		Node node;		// 삽입하려는 노드
		Node tmp;		// 교환을 위한 임시노드
		int point;		// 삽입하려는 노드의 배열에서의 현재 위치
		int parent;
		
		node = new Node();
		node.setValue(data);
		
		point = curSize;
		bHeap[point] = node;		// 배열은 0부터 시작하므로
		curSize++;					// curSize의 위치는 빈 셀
		
		for (int i=0; i<curSize; i++) {		// 교환 시작
			if (point == 0)
				return 0;
			
			parent = getParent(point);
			
			if (bHeap[parent].getValue() < bHeap[point].getValue())
				return 0;		// 부모의 우선순위가 더 크기 때문에 삽입 끝
			else {
				tmp = bHeap[point];		// 부모와 실제로 위치 교환
				bHeap[point] = bHeap[parent];
				bHeap[parent] = tmp;
				
				point = parent;		// 옮겨간 위치에서 다시 우선순위 비교하기 위해
			}
		}
		return -1; // 삽입 실패
	}
	
	public Node delete() {
		Node delNode;		// 삭제된 노드
		Node tmp;			// 교환을 위한 임시노드
		int point;			// 루트로 옮겨온 노드의 배열에서의 현재 위치
		int left, right;	// 왼쪽 자식과 오른쪽 자식노드
		int winner;			// 두 자식노드 중 우선순위가 높은 노드
		
		tmp = new Node();
		
		if ((delNode = bHeap[0]) == null)
			return delNode;		//힙에 자료가 없으므로 실패
		
		point = 0;
		bHeap[point] = bHeap[curSize - 1];	// 힙의 마지막 노드를 루트에 옮김
		curSize--;
		
		for (int i=0; i<curSize; i++) {		// 교환 시작
			left = getLeftChild(point);
			right = getRightChild(point);
			
			if (left > curSize) {	// 자식이 없는 노드 이므로 삭제를 마침
				// 삭제한 노드를 힙의 빈자리에 놓는다
				bHeap[curSize] = delNode;
				return delNode;
			} else if (right > curSize) {
				// 오른쪽 자식노드가 없으므로 왼쪽 자식노드만 선택된다
				winner = left;
			} else {
				// 자식노드가 둘 다 존재할 때
				if (bHeap[left].getValue() > bHeap[right].getValue())
					winner = right;
				else
					winner = left;
			}
			
			if (bHeap[winner].getValue() > bHeap[point].getValue()) {
				// 삭제한 노드를 힙의 빈자리에 놓는다
				bHeap[curSize] = delNode;
				return delNode;
			} else {
				tmp = bHeap[point];		// 부모와 실제로 위치 교환
				bHeap[point] = bHeap[winner];
				bHeap[winner] = tmp;
				
				// 옮겨간 위치에서 다시 우선순위를 비교하기 위해
				point = winner;
			}
		}
		bHeap[curSize] = delNode;
		return delNode;		
	}
	
	public void showHeap() {	// 힙에 속한 노드만을 보여줌		
		for (int i=0; i<curSize; i++)
			System.out.print(bHeap[i].getValue() + " ");
		System.out.println("");		
	}
	
	public void showHeapSort() {	// 힙의 노드와 정렬된 자료까지 모두 보여줌
		for (int i=0; i<curSize; i++)
			System.out.print(bHeap[i].getValue() + " ");
		System.out.print("|");
		for (int i=curSize; i<arraySize; i++)
			System.out.print(bHeap[i].getValue() + " ");
		System.out.println();
		
	}
	
	
}
