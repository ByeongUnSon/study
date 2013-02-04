package designpattern.gof.abstractfactory.before;

// 화면을 구성하는 게임 컴포넌트들
public abstract class StageComponent {
	int x, y; // 화면의 좌표
	
	StageComponent() {
		x = y = 0;
	}
	
	StageComponent(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	// 속성의 int x, int y 값에 따라 자신의 모습을 그린다
	abstract public void draw();
}


