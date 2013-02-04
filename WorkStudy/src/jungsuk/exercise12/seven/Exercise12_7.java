package jungsuk.exercise12.seven;
/**
 * 다음의 코드는 쓰레드 th1을 생성해서 실행시킨 다음 6초 후에 정지시키는 코드이다. 
 * 그러나 실제로 실행시켜보면 쓰레드를 정지시킨 다음에도 몇 초가 지난 후에서야 멈춘다. 
 * 그 이유를 설명하고, 쓰레드를 정지시키면 지체없이 바로 정지되도록 코드를 개선하시오.
 * 
 *
 */
public class Exercise12_7 {
	static boolean stopped = false;

	public static void main(String[] args) {
		Thread5 th1 = new Thread5();
		th1.start();
		try {
			Thread.sleep(6 * 1000);
		} catch (Exception e) {
		}
		stopped = true; // 쓰레드를 정지시킨다.
		th1.interrupt(); // 쓰레드를 깨운다.
		System.out.println("stopped");
	}
}
/**
 * interrupt()는 InterruptedException을 발생시킴으로써 Thread.sleep()에 의해 일시정지
	상태에 있던 쓰레드를 즉시 깨운다.
	그래서 Exercise12_7.stopped의 값을 true로 바꾸고, interrupt()를 호출하면 지연 없이
	즉시 쓰레드를 멈추게 할 수 있다.
 *
 */
class Thread5 extends Thread {
	public void run() {
		// Exercise12_7.stopped의 값이 false인 동안 반복한다.
		for (int i = 0; !Exercise12_7.stopped; i++) {
			System.out.println(i);
			try {
				Thread.sleep(3 * 1000);	// 3초간 쉰다.
			} catch (Exception e) {
			}
		}
	} // run()
}
