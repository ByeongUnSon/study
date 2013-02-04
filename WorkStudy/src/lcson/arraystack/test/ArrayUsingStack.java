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
		aStack.peek(popItem);	// 스택에서 자료읽기
		System.out.println(popItem[0]); 
		
		System.out.print("pop : ");
		while (aStack.pop(popItem)) {	// 스택이 공백상태가 될 때까지
										// 스택으로부터 자료 제거
			System.out.print(popItem[0] + " "); // 제거된 자료 출력
		}
		System.out.println("");
	}

}
