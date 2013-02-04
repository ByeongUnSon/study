package lcson.liststack.test;

public class ListUsingStack {

	public static void main(String[] args) {
		
		ListStack lStack = new ListStack();
		
		Object pushItem;
		System.out.print("Push : ");
		for (int i=0; i<3; i++) {
			pushItem = (i+1) * 10;
			lStack.push(pushItem);
			System.out.print(pushItem + " ");
		}
		System.out.println("");

		Object[] popItem = new Object[1];
		System.out.print("Peek : ");
		lStack.peek(popItem);
		System.out.println(popItem[0]);
		
		System.out.print("Pop : ");
		
		while (lStack.pop(popItem)) {
			System.out.print(popItem[0] + " ");
		}
		System.out.println("");
	}

}
