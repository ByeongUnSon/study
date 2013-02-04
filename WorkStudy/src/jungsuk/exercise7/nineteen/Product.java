package jungsuk.exercise7.nineteen;

public class Product {
	int price;
	
	Product(int price) {
		this.price = price;
	}
		
}

class Tv extends Product {
	Tv() { super(100); }
	
	@Override
	public String toString() { return "Tv"; }
	
}

class Computer extends Product {
	Computer() { super(200); }
	
	@Override
	public String toString() { return "Computer"; }
}

class Audio extends Product {
	Audio() { super(50); }
	
	@Override
	public String toString() { return "Audio"; }
}
