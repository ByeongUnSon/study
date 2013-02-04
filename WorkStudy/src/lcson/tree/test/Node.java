package lcson.tree.test;

public class Node {
	public int keyData;		// 데이터(키)
	public Node leftChild;		// 노드의 왼쪽 자식
	public Node rightChild;		// 노드의 오른쪽 자식
	
	// 노드 정보 출력
	public void showNode() {
		System.out.print('[');
		System.out.print(keyData);
		System.out.print(']');
	}
}
