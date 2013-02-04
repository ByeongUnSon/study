package lcson.tree.test;

import java.util.Stack;

public class BinaryTree {
	private Node root;		// Ʈ���� ��Ʈ ���
	
	public BinaryTree() {
		root = null;
	}
	
	public void traverse(int type) {
		switch (type) {
			case 1:
				System.out.print("Preorder traversal: ");
				preOrder(root);
				break;
			case 2:
				System.out.print("Inorder traversal: ");
				inOrder(root);
				break;
			case 3:
				System.out.print("Postorder traversal: ");
				postOrder(root);
				break;
		}
		System.out.println();
	}
	
	private void preOrder(Node tempRoot) {
		if (tempRoot != null) {
			System.out.print(tempRoot.keyData + " ");
			preOrder(tempRoot.leftChild);
			preOrder(tempRoot.rightChild);
		}
	}
	
	private void inOrder(Node tempRoot) {
		if (tempRoot != null) {
			inOrder(tempRoot.leftChild);
			System.out.print(tempRoot.keyData + " ");
			inOrder(tempRoot.rightChild);
		}
	}
	
	private void postOrder(Node tempRoot) {
		if (tempRoot != null) {
			postOrder(tempRoot.leftChild);
			postOrder(tempRoot.rightChild);
			System.out.print(tempRoot.keyData + " ");
		}
	}
	
	// Ž��
	public Node find(int key) {
		Node current = root;
		
		if (current == null)
			return null;
		
		while (current.keyData != key) {

			if (key < current.keyData)
				current = current.leftChild;
			else
				current = current.rightChild;
		}
		return current;
	}
	
	// �ִ�, �ּҰ� Ž��
	public Node findMin() {
		Node current = root;
		while (current.leftChild != null)
			current = current.leftChild;
		return current;
	}
	
	public Node findMax() {
		Node current = root;
		while (current.rightChild != null)
			current = current.rightChild;
		return current;
	}
	
	public void insert(int key) {
		Node insertNode = new Node();	// ����� ����
		insertNode.keyData = key;
		if (root == null)   // ���ο� Ʈ�� ����
			root = insertNode;
		else {
			Node current = root;
			Node parent;
			
			while (true) {
				parent = current;			// �θ��弳��
				if (key < current.keyData) {
					current = current.leftChild;
					if (current == null) {	// ���� ��ġ�� ���� ����
						parent.leftChild = insertNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = insertNode;
						return;
					}
				}
			}
		}
	}
	
	public boolean delete(int key) {
		Node current = root;
		Node parent = current;
		
		if (current == null)	// Ű���� ���� ��� ����
			return false;
		
		while (current.keyData != key) {
			parent = current;
			
			if (key < current.keyData)
				current = current.leftChild;
			else
				current = current.rightChild;			
		}
		// �ڽ��� ���� ��
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root)	// Ʈ�� ����
				root = null;
			else if (current == parent.leftChild)
				parent.leftChild = null;
			else 
				parent.rightChild = null;
		} else if (current.rightChild == null) {	// ���� �ڽĸ� ����
			if (current == root) 
				root = current.leftChild;
			else if (current == parent.leftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		} else if (current.leftChild == null) {	// ������ �ڽĸ� ����
			if (current == root)
				root = current.rightChild;
			else if (current == parent.leftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		} else {		// �ڽ��� ���� ��
			// ��������� �ĺ���� ã��
			Node candidate = getCandidate(current);
			
			if (current == root)
				root = candidate;
			else if (current == parent.leftChild)
				parent.leftChild = candidate;
			else
				parent.rightChild = candidate;
			
			candidate.leftChild = current.leftChild;
		}
		return true;
	}
	
	// �ĺ� ��带 ã�� �ĺ���带 ��������� ������ ���� �����
	private Node getCandidate(Node deleteNode) {
		Node candidateParent = deleteNode;
		Node candidate = candidateParent.rightChild;
		
		// ������� ������ �ڽ��� ���� �ڽ� ã��
		while (candidate.leftChild != null) {
			candidateParent = candidate;
			candidate = candidate.leftChild;
		}
		
		// �ĺ���尡 ������� ������ �ڽ��� ���� �ڽ��� ��
		if (candidate != deleteNode.rightChild) {
			candidateParent.leftChild = candidate.rightChild;
			candidate.rightChild = deleteNode.rightChild;
		}
		
		return candidate;
	}
	
	public void display() {
		Stack<Object> globalStack = new Stack<Object>();
		globalStack.push(root);
		int blank = 32;
		boolean isRowEmpty = false;
		
		while (isRowEmpty == false) {
			Stack<Object> localStack = new Stack<Object>();
			isRowEmpty = true;
			for (int i=0; i<blank; i++)
				System.out.print(' ');
			
			while (globalStack.isEmpty() == false) {
				Node temp = (Node) globalStack.pop();
				
				if (temp != null) {
					System.out.print(temp.keyData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					
					if (temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				} else {
					System.out.print("**");
					localStack.push(null);
					localStack.push(null);
				}
				for (int i=0; i < blank * 2 - 2; i++)
					System.out.print(' ');
			}
			System.out.println();
			blank = blank / 2;
			
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		}
		System.out.println();
	}
}
