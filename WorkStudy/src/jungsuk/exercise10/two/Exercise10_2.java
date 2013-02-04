/**
 * 
 */
package jungsuk.exercise10.two;

class Outer {
	static class Inner {
		int iv=200;
	}
}



public class Exercise10_2 {


	public static void main(String[] args) {
		
		Outer.Inner inner = new Outer.Inner();
		System.out.println(inner.iv);
		
		System.out.println(new Outer.Inner().iv);
	}

}
