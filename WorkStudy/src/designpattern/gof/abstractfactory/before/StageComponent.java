package designpattern.gof.abstractfactory.before;

// ȭ���� �����ϴ� ���� ������Ʈ��
public abstract class StageComponent {
	int x, y; // ȭ���� ��ǥ
	
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
	
	// �Ӽ��� int x, int y ���� ���� �ڽ��� ����� �׸���
	abstract public void draw();
}


