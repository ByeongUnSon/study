package jungsuk.exercise10.one;


class Outer {
	class Inner {
		int iv=100;
	}
}


public class Exercise10_1 {

	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner ii = o.new Inner();
		System.out.println(o.new Inner().iv);
		System.out.println(ii.iv);
	}

}

