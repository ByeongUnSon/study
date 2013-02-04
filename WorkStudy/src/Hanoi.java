public class Hanoi {

	static int num_disk = 3;
	
	public static void main(String[] args) {
		moveDisk(num_disk, 'A', 'B', 'C'); 
	}
	
	static void moveDisk(int top, char from, char mid, char to) {
		if (top == 1) 
			System.out.println("[원판 1]이 [기둥 " + from + "]에서 [기둥 " + to + "]로 이동");
		else {
			moveDisk(top - 1, from, to, mid); // from 에서 mid 로 이동
			System.out.println("[원판 " + top + "]이 [기둥 " + from + "]에서 [기둥 " + to + "]로 이동");		
			moveDisk(top - 1, mid, from, to); // mid 에서 to 로 이동
		}
	}

}
