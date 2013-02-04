package jungsuk.exercise12.seven;
/**
 * ������ �ڵ�� ������ th1�� �����ؼ� �����Ų ���� 6�� �Ŀ� ������Ű�� �ڵ��̴�. 
 * �׷��� ������ ������Ѻ��� �����带 ������Ų �������� �� �ʰ� ���� �Ŀ����� �����. 
 * �� ������ �����ϰ�, �����带 ������Ű�� ��ü���� �ٷ� �����ǵ��� �ڵ带 �����Ͻÿ�.
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
		stopped = true; // �����带 ������Ų��.
		th1.interrupt(); // �����带 �����.
		System.out.println("stopped");
	}
}
/**
 * interrupt()�� InterruptedException�� �߻���Ŵ���ν� Thread.sleep()�� ���� �Ͻ�����
	���¿� �ִ� �����带 ��� �����.
	�׷��� Exercise12_7.stopped�� ���� true�� �ٲٰ�, interrupt()�� ȣ���ϸ� ���� ����
	��� �����带 ���߰� �� �� �ִ�.
 *
 */
class Thread5 extends Thread {
	public void run() {
		// Exercise12_7.stopped�� ���� false�� ���� �ݺ��Ѵ�.
		for (int i = 0; !Exercise12_7.stopped; i++) {
			System.out.println(i);
			try {
				Thread.sleep(3 * 1000);	// 3�ʰ� ����.
			} catch (Exception e) {
			}
		}
	} // run()
}
