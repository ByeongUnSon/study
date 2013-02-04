package jungsuk.exercise11.twelve;

import java.util.*;

public class Exercise11_12 {

	public static void main(String[] args) throws Exception {
		SutdaDeck deck = new SutdaDeck();
		deck.shuffle();
		Player p1 = new Player("Ÿ¥", deck.pick(), deck.pick());
		Player p2 = new Player("����", deck.pick(), deck.pick());
		System.out.println(p1+" "+deck.getPoint(p1));
		System.out.println(p2+" "+deck.getPoint(p2));
	}

}

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	int pos = 0; // ������ ������ ī���� ��ġ
	HashMap<Object, Object> jokbo = new HashMap<Object, Object>(); // ������ ������ HashMap

	SutdaDeck() {
		for (int i = 0; i < cards.length; i++) {
			int num = i % 10 + 1;
			boolean isKwang = i < 10 && (num == 1 || num == 3 || num == 8);
			cards[i] = new SutdaCard(num, isKwang);
		}
		registerJokbo(); // ������ ����Ѵ�.
	}

	void registerJokbo() {
		/*
		 * (1) �Ʒ��� ������ �°� �ڵ带 �ۼ��Ͻÿ�. 
		 * 1. jokbo(HashMap)�� ������ �����Ѵ�. 
		 * �� ī���� ���� ���ڿ��� �ٿ��� key��, ������ value�� �����Ѵ�.
		 */
		jokbo.put("KK", 4000);
		jokbo.put("1010", 3100);
		jokbo.put("99", 3090);
		jokbo.put("88", 3080);
		jokbo.put("77", 3070);
		jokbo.put("66", 3060);
		jokbo.put("55", 3050);
		jokbo.put("44", 3040);
		jokbo.put("33", 3030);
		jokbo.put("22", 3020);
		jokbo.put("11", 3010);
		jokbo.put("12", 2060);
		jokbo.put("21", 2060);
		jokbo.put("14", 2050);
		jokbo.put("41", 2050);
		jokbo.put("19", 2040);
		jokbo.put("91", 2040);
		jokbo.put("110", 2030);
		jokbo.put("410", 2020);
		jokbo.put("104", 2020);
		jokbo.put("46", 2010);
		jokbo.put("64", 2010);
	}

	int getPoint(Player p) {
		if (p == null)
			return 0;
		SutdaCard c1 = p.c1;
		SutdaCard c2 = p.c2;
		Integer result = 0;
		/*
		 * (2) �Ʒ��� ������ �°� �ڵ带 �ۼ��Ͻÿ�. 1. ī�� �� ���� ��� ���̸�, jokbo���� Ű�� "KK"�� �ؼ� ������
		 * ��ȸ�Ѵ�. 2. �� ī���� ����(num)�� jokbo���� ����� ��ȸ�Ѵ�. 3. �ش��ϴ� ����� ������, �Ʒ��� ��������
		 * ������ ����Ѵ�. (c1.num + c2.num) % 10 + 1000 4. Player�� ����(point)�� ����� ����
		 * �����Ѵ�.
		 */
		
		// ī�� ������ ��� ���̸� KK�� �ؼ� ������ ��ȸ
		if (c1.isKwang && c2.isKwang) {
			result = (Integer) jokbo.get("KK");
		} else {
			result = (Integer) jokbo.get(""+c1.num+c2.num);
			
			if (result == null) {
				result = (Integer)((c1.num + c2.num) % 10 + 1000);
			}		
		}
		p.point = result.intValue();
		
		return result.intValue();
	}

	SutdaCard pick() throws Exception {
		SutdaCard c = null;
		if (0 <= pos && pos < CARD_NUM) {
			c = cards[pos];
			cards[pos++] = null;
		} else {
			throw new Exception("�����ִ� ī�尡 �����ϴ�.");
		}
		return c;
	}

	void shuffle() {
		for (int x = 0; x < CARD_NUM * 2; x++) {
			int i = (int) (Math.random() * CARD_NUM);
			int j = (int) (Math.random() * CARD_NUM);
			SutdaCard tmp = cards[i];
			cards[i] = cards[j];
			cards[j] = tmp;
		}
	}
} // SutdaDeck

class Player {
	String name;
	SutdaCard c1;
	SutdaCard c2;
	int point; // ī���� ��޿� ���� ���� - ���� �߰�

	Player(String name, SutdaCard c1, SutdaCard c2) {
		this.name = name;
		this.c1 = c1;
		this.c2 = c2;
	}

	public String toString() {
		return "[" + name + "]" + c1.toString() + "," + c2.toString();
	}
} // class Player

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}