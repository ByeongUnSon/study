package jungsuk.exercise12.one;

/**
 * �����带 �����ϴ� ������� ThreadŬ�����κ��� ��ӹ޴� �Ͱ� 
 * Runnable�������̽��� �����ϴ� �� �� ������ �ִµ�, 
 * ������ �ڵ�� ThreadŬ������ ��ӹ޾Ƽ� �����带 ������ ���̴�. 
 * �� �ڵ带 Runnable�������̽��� �����ϵ��� �����Ͻÿ�.
 *
 */
public class Exercise12_1 {
	
	public static void main(String args[]) {
		new Thread(new Thread1()).start();		
	}
}

class Thread1 implements Runnable {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print('-');
		}
	}
}