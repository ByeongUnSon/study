package lcson.anagram.test;

public class Anagram {
	
	static int num_recursive = 3;

	public static void main(String[] args) {	
		swap(num_recursive, 'c', 'a', 't');			
	}
	
	static void swap(int top, char from, char mid, char to) {
		StringBuffer sb = new StringBuffer();
		if (top == 0)  {
			return;
		} else if (top == 1) {
			String str = sb.append(from).append(mid).append(to).toString();
			System.out.println(str);
		} else {
			swap(top - 1, from, to, mid); 
			String str = sb.append(from).append(mid).append(to).toString();
			
			if (!str.equals("cat"))
				System.out.println(str);
			swap(top - 1, mid, to, from);
		}
	}
	
}
