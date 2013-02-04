package jungsuk.exercise7.nineteen;

public class Buyer {
	int money = 1000;
	Product[] cart = new Product[3]; // ������ ��ǰ�� �����ϱ� ���� �迭
	int i = 0; // Product�迭 cart�� ���� index

	void buy(Product p) {
		if (money < p.price) {
			System.out.println("�ܾ��� �����Ͽ� " + p + "��/�� �� �� �����ϴ�.");
			return;
		}
		money -= p.price;
		add(p);
	}

	void add(Product p) {
		if (i >= cart.length) {
			Product[] temp = new Product[cart.length * 2];
			System.arraycopy(cart, 0, temp, 0, cart.length);
			cart = temp;
			cart[i++] = p;
		} 
		else 
			cart[i++] = p;

 	}

	void summary() {
		String itemList = "";
		int totalPrice = 0;
		for (int i = 0; i < cart.length; i++) {
			if (cart[i] == null)
				break;
			itemList += cart[i] + ",";
			totalPrice += cart[i].price;
		}
		System.out.println("������ ���� : " + itemList);
		System.out.println("����� �ݾ� : " + totalPrice);
		System.out.println("���� �ݾ� : " + money);
	}
}
