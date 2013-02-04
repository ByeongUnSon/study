package lcson.heapsort.test;
/**
 * ũ�Ⱑ �������� �켱������ ���������� �����Ѵ�.
 * 
 * @author Administrator
 *
 */
public class HeapSort {
	private int arraySize;		// ���� �����ϴ� �迭�� ũ��
	private int curSize;		// ���� ���� ���� �ִ� �ڷ� ����
	private Node[] bHeap;
	
	public HeapSort(int arraySize) {
		this.arraySize = arraySize;
		bHeap = new Node[arraySize];
		curSize = 0;
	}
	
	public int getParent(int child) {
		if ((child % 2) == 1)	// Ȧ�� �̹Ƿ� ���� �ڽ�
			 return (int)((child - 1) / 2);
		else	// ¦�� �̹Ƿ� ������ �ڽ�
			return (int)((child - 2) / 2);
	}
	
	public int getLeftChild(int parent) {
		return (parent * 2) + 1;
	}
	
	public int getRightChild(int parent) {
		return (parent * 2) + 2;
	}
	
	public int insert(int data) {
		Node node;		// �����Ϸ��� ���
		Node tmp;		// ��ȯ�� ���� �ӽó��
		int point;		// �����Ϸ��� ����� �迭������ ���� ��ġ
		int parent;
		
		node = new Node();
		node.setValue(data);
		
		point = curSize;
		bHeap[point] = node;		// �迭�� 0���� �����ϹǷ�
		curSize++;					// curSize�� ��ġ�� �� ��
		
		for (int i=0; i<curSize; i++) {		// ��ȯ ����
			if (point == 0)
				return 0;
			
			parent = getParent(point);
			
			if (bHeap[parent].getValue() < bHeap[point].getValue())
				return 0;		// �θ��� �켱������ �� ũ�� ������ ���� ��
			else {
				tmp = bHeap[point];		// �θ�� ������ ��ġ ��ȯ
				bHeap[point] = bHeap[parent];
				bHeap[parent] = tmp;
				
				point = parent;		// �Űܰ� ��ġ���� �ٽ� �켱���� ���ϱ� ����
			}
		}
		return -1; // ���� ����
	}
	
	public Node delete() {
		Node delNode;		// ������ ���
		Node tmp;			// ��ȯ�� ���� �ӽó��
		int point;			// ��Ʈ�� �Űܿ� ����� �迭������ ���� ��ġ
		int left, right;	// ���� �ڽİ� ������ �ڽĳ��
		int winner;			// �� �ڽĳ�� �� �켱������ ���� ���
		
		tmp = new Node();
		
		if ((delNode = bHeap[0]) == null)
			return delNode;		//���� �ڷᰡ �����Ƿ� ����
		
		point = 0;
		bHeap[point] = bHeap[curSize - 1];	// ���� ������ ��带 ��Ʈ�� �ű�
		curSize--;
		
		for (int i=0; i<curSize; i++) {		// ��ȯ ����
			left = getLeftChild(point);
			right = getRightChild(point);
			
			if (left > curSize) {	// �ڽ��� ���� ��� �̹Ƿ� ������ ��ħ
				// ������ ��带 ���� ���ڸ��� ���´�
				bHeap[curSize] = delNode;
				return delNode;
			} else if (right > curSize) {
				// ������ �ڽĳ�尡 �����Ƿ� ���� �ڽĳ�常 ���õȴ�
				winner = left;
			} else {
				// �ڽĳ�尡 �� �� ������ ��
				if (bHeap[left].getValue() > bHeap[right].getValue())
					winner = right;
				else
					winner = left;
			}
			
			if (bHeap[winner].getValue() > bHeap[point].getValue()) {
				// ������ ��带 ���� ���ڸ��� ���´�
				bHeap[curSize] = delNode;
				return delNode;
			} else {
				tmp = bHeap[point];		// �θ�� ������ ��ġ ��ȯ
				bHeap[point] = bHeap[winner];
				bHeap[winner] = tmp;
				
				// �Űܰ� ��ġ���� �ٽ� �켱������ ���ϱ� ����
				point = winner;
			}
		}
		bHeap[curSize] = delNode;
		return delNode;		
	}
	
	public void showHeap() {	// ���� ���� ��常�� ������		
		for (int i=0; i<curSize; i++)
			System.out.print(bHeap[i].getValue() + " ");
		System.out.println("");		
	}
	
	public void showHeapSort() {	// ���� ���� ���ĵ� �ڷ���� ��� ������
		for (int i=0; i<curSize; i++)
			System.out.print(bHeap[i].getValue() + " ");
		System.out.print("|");
		for (int i=curSize; i<arraySize; i++)
			System.out.print(bHeap[i].getValue() + " ");
		System.out.println();
		
	}
	
	
}
