public class Hanoi {

	static int num_disk = 3;
	
	public static void main(String[] args) {
		moveDisk(num_disk, 'A', 'B', 'C'); 
	}
	
	static void moveDisk(int top, char from, char mid, char to) {
		if (top == 1) 
			System.out.println("[���� 1]�� [��� " + from + "]���� [��� " + to + "]�� �̵�");
		else {
			moveDisk(top - 1, from, to, mid); // from ���� mid �� �̵�
			System.out.println("[���� " + top + "]�� [��� " + from + "]���� [��� " + to + "]�� �̵�");		
			moveDisk(top - 1, mid, from, to); // mid ���� to �� �̵�
		}
	}

}
