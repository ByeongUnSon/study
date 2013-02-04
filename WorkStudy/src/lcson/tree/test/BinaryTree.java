package lcson.tree.test;

import java.util.Stack;

public class BinaryTree {
	private Node root;		// 트리의 루트 노드
	
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
	
	// 탐색
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
	
	// 최대, 최소값 탐색
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
		Node insertNode = new Node();	// 새노드 생성
		insertNode.keyData = key;
		if (root == null)   // 새로운 트리 생성
			root = insertNode;
		else {
			Node current = root;
			Node parent;
			
			while (true) {
				parent = current;			// 부모노드설정
				if (key < current.keyData) {
					current = current.leftChild;
					if (current == null) {	// 현재 위치에 삽입 가능
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
		
		if (current == null)	// 키값을 갖는 노드 없음
			return false;
		
		while (current.keyData != key) {
			parent = current;
			
			if (key < current.keyData)
				current = current.leftChild;
			else
				current = current.rightChild;			
		}
		// 자식이 없을 때
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root)	// 트리 삭제
				root = null;
			else if (current == parent.leftChild)
				parent.leftChild = null;
			else 
				parent.rightChild = null;
		} else if (current.rightChild == null) {	// 왼쪽 자식만 존재
			if (current == root) 
				root = current.leftChild;
			else if (current == parent.leftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		} else if (current.leftChild == null) {	// 오른쪽 자식만 존재
			if (current == root)
				root = current.rightChild;
			else if (current == parent.leftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		} else {		// 자식이 둘일 때
			// 삭제노드의 후보노드 찾기
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
	
	// 후보 노드를 찾고 후보노드를 삭제노드의 오른쪽 노드로 만든다
	private Node getCandidate(Node deleteNode) {
		Node candidateParent = deleteNode;
		Node candidate = candidateParent.rightChild;
		
		// 삭제노드 오른쪽 자식의 왼쪽 자식 찾기
		while (candidate.leftChild != null) {
			candidateParent = candidate;
			candidate = candidate.leftChild;
		}
		
		// 후보노드가 삭제노드 오른쪽 자식의 왼쪽 자식일 때
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
