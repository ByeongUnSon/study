/**
 * 
 */
package jungsuk.exercise10.three;

class Outer {
	int value = 10;

	class Inner {
		int value = 20;

		void method1() {
			int value = 30;
			System.out.println(value);
			System.out.println(this.value);
			System.out.println(Outer.this.value);
		}
	} // InnerŬ������ ��
} // OuterŬ������ ��

public class Exercise10_3 {

	public static void main(String[] args) {
		
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method1();
		
	}

}
