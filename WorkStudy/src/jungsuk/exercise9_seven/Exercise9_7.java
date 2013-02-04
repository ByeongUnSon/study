/**
 * 
 */
package jungsuk.exercise9_seven;

/**
 * @author Administrator
 *
 */
public class Exercise9_7 {

	static boolean contains(String src, String target) {
		int pos = 0;
		pos = src.indexOf(target, pos);
		if (pos != -1) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(contains("12345","23"));
		System.out.println(contains("12345","67"));
	}

}
