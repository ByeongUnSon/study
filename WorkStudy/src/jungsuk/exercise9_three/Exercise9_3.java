/**
 * 
 */
package jungsuk.exercise9_three;


/**
 * @author Administrator
 *
 */
public class Exercise9_3 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.5\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";
		
		// lastIndexOf ������ ��� ������
		int pos = fullPath.lastIndexOf("\\");
		
		if (pos != -1) {
			path = fullPath.substring(0, pos);
			fileName = fullPath.substring(pos+1);
		}
		System.out.println("fullPath=" + fullPath);
		System.out.println("path=" + path);
		System.out.println("fileName=" + fileName);		
	}

}
