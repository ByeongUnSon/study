package jungsuk.exercise7.nineteen;

public class Buyer {
	int money = 1000;
	Product[] cart = new Product[3]; // 구입한 제품을 저장하기 위한 배열
	int i = 0; // Product배열 cart에 사용될 index

	void buy(Product p) {
		if (money < p.price) {
			System.out.println("잔액이 부족하여 " + p + "을/를 살 수 없습니다.");
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
		System.out.println("구입한 물건 : " + itemList);
		System.out.println("사용한 금액 : " + totalPrice);
		System.out.println("남은 금액 : " + money);
	}
}
