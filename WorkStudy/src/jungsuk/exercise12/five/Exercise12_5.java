package jungsuk.exercise12.five;


/**
 * main과 th1 두 개의 쓰레드는 별도의 호출스택(call stack)에서 실행된다.
 * 그래서 main에서 예외가 발생하여 종료되고 호출스택이 없어져도, 쓰레드 th1이 실행되는
 * 호출스택에는 아무런 영향을 미치지 못한다.
 * 
 * @author Administrator
 *
 */

public class Exercise12_5 {
	public static void main(String[] args) throws Exception {
		Thread3 th1 = new Thread3();
		th1.start();
		try {
			Thread.sleep(5 * 1000);
		} catch (Exception e) {
		}
		throw new Exception("꽝~!!!");
	}
}

class Thread3 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	} // run()
}