package jungsuk.exercise12.five;


/**
 * main�� th1 �� ���� ������� ������ ȣ�⽺��(call stack)���� ����ȴ�.
 * �׷��� main���� ���ܰ� �߻��Ͽ� ����ǰ� ȣ�⽺���� ��������, ������ th1�� ����Ǵ�
 * ȣ�⽺�ÿ��� �ƹ��� ������ ��ġ�� ���Ѵ�.
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
		throw new Exception("��~!!!");
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