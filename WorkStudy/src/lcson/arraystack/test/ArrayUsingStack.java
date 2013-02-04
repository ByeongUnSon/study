package lcson.arraystack.test;

public class ArrayUsingStack {

	public static void main(String[] args) {
		int stackSize = 10;
		ArrayStack aStack = new ArrayStack(stackSize);
		Object pushItem;
		System.out.print("push : ");
		for (int i=0; i<stackSize; i++) {
			pushItem = (i+1) * 10;
			aStack.push(pushItem);
			System.out.print(pushItem + " ");
		}
		System.out.println("");
		Object popItem[] = new Object[1];
		System.out.print("peek : ");
		aStack.peek(popItem);	// ���ÿ��� �ڷ��б�
		System.out.println(popItem[0]); 
		
		System.out.print("pop : ");
		while (aStack.pop(popItem)) {	// ������ ������°� �� ������
										// �������κ��� �ڷ� ����
			System.out.print(popItem[0] + " "); // ���ŵ� �ڷ� ���
		}
		System.out.println("");
	}

}
