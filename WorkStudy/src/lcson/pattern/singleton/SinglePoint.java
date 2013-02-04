package lcson.pattern.singleton;

public class SinglePoint {
	private static SinglePoint instance = new SinglePoint();
	
	private int x, y;
	
	private SinglePoint() {
		x = 0;
		y = 0;
	}
	
	public static SinglePoint getInstance() {
		return instance;
	}
	
	public void moveBy(int dx, int dy) {
		x = x + dx;
		y = y + dy;
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}
	
	public void show() {
		System.out.print("(" + x +"," + y + ")");
	}
}
