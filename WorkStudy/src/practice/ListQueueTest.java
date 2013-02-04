package practice;

public class ListQueueTest {

	public static void main(String[] args) throws MyException {
		ListQueue queue = new ListQueue();
		
		System.out.println(queue.enQueue("Å×½ºÆ®123"));
		System.out.println(queue.enQueue("1123"));
		System.out.println(queue.enQueue("abcd"));
		
		System.out.println("---------------------");
		
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.peek());
		System.out.println(queue.enQueue("Tester"));
		System.out.println(queue.peek());
		//System.out.println(queue.deQueue());
	}

}
