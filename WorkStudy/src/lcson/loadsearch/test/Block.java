package lcson.loadsearch.test;

import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class Block extends JPanel {

	private static final long serialVersionUID = 1L;
	int type;
	boolean unitObject;
	
	Block (int x, int y, int type) {
		this.type = type;
		setBounds(x * 20, y * 20, 19, 19);
	}
	
	public int getType() {
		return type;
	}
	
	abstract public void paintComponent(Graphics g);
	
	public void changeType() {
		if (type == 0)
			type = 1;
		else if (type == 1)
			type = 0;
		else 
			System.out.println("벽은 없앨 수 없습니다.(유닛은 탈출할수도 있음)");
		
		super.repaint();
	}
	
	public void setUnitObject(boolean unitObject) {
		this.unitObject = unitObject;
		super.repaint();
	}
	
}
