package jungsuk.exercise7.eighteen;

public class Exercise7_18 {
	
	
	static void action(Robot r) {
		if (r instanceof DanceRobot) {
			//new DanceRobot().dance();
			DanceRobot d = (DanceRobot) r;
			d.dance();
		} else if (r instanceof SingRobot) {
			//new SingRobot().sing();
			SingRobot sing = (SingRobot) r;
			sing.sing();
		} else if (r instanceof DrawRobot) {
			//new DrawRobot().draw();
			DrawRobot draw = (DrawRobot) r;
			draw.draw();
		}
	}
	
	public static void main(String[] args) {
		Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot() };
		
		for (int i=0; i<arr.length; i++)
			action(arr[i]);
	}

}

class Robot { }

class DanceRobot extends Robot {
	void dance() {
		System.out.println("���� ��ϴ�.");
	}
}

class SingRobot extends Robot {
	void sing() {
		System.out.println("�뷡�� �մϴ�.");
	}
}

class DrawRobot extends Robot {
	void draw() {
		System.out.println("�׸��� �׸��ϴ�.");
	}
}
