package lcson.tree.test;

public class Node {
	public int keyData;		// ������(Ű)
	public Node leftChild;		// ����� ���� �ڽ�
	public Node rightChild;		// ����� ������ �ڽ�
	
	// ��� ���� ���
	public void showNode() {
		System.out.print('[');
		System.out.print(keyData);
		System.out.print(']');
	}
}
