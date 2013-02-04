package jungsuk.exercise12.nine;

import java.util.*;

/**
 * ������ �ڵ�� �ؽ�Ʈ����� Ÿ�ڿ��������ε� WordGenerator��� �����尡 Vector�� 2�ʸ��� �ܾ �ϳ��� �߰��ϰ�, ����ڰ�
 * �ܾ �Է��ϸ� Vector���� ��ġ�ϴ� �ܾ �����ϵ��� �Ǿ� �ִ�. WordGenerator�� run()�� �ϼ��Ͻÿ�.
 * 
 */
class Exercise12_9 {
	Vector<Object> words = new Vector<Object>();
	String[] data = { "�¿�", "����", "����", "ȿ��", "����", "����", "Ƽ�Ĵ�", "���", "����ī" };
	int interval = 2 * 1000; // 2��
	WordGenerator wg = new WordGenerator();

	public static void main(String args[]) {
		Exercise12_9 game = new Exercise12_9();
		game.wg.start();
		Vector<Object> words = game.words;
		while (true) {
			System.out.println(words);
			String prompt = ">>";
			System.out.print(prompt);
			// ȭ�����κ��� ���δ����� �Է¹޴´�.
			Scanner s = new Scanner(System.in);
			String input = s.nextLine().trim();
			int index = words.indexOf(input);
			if (index != -1) {
				words.remove(index);
			}
			if (input.equalsIgnoreCase("q")) {
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
		}
	} // main

	class WordGenerator extends Thread {
		public void run() {
			/*
			 * (1) �Ʒ��� ������ �°� �ڵ带 �ۼ��Ͻÿ�. 1. interval(2��)���� �迭 data�� �� �� �ϳ��� ���Ƿ�
			 * �����ؼ� 2. words�� �����Ѵ�.
			 */
			while (true) {
				int pos = (int) (Math.random() * data.length);
				words.add(data[pos]);

				try {
					Thread.sleep(interval);
				} catch (InterruptedException e) {
				}
			}

		} // end of run()
	} // class WordGenerator
} // Exercise12_9