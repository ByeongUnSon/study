package lcson.loadsearch.test;

import java.awt.Color;
import java.awt.Graphics;

public class Node extends Block {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int nodeX;
	int nodeY;
	int state;	// 0 -> 미확인 , 1-> oper, 2-> close
	
	int f;
	int g;
	int h;
	
	boolean haveParent;
	int parentX;
	int parentY;
	boolean select;
	boolean makeLoad;
	boolean obstacle; // 장애물
	boolean corner;	   // 모서리
	
	Node (int x, int y, int t) {
		super(x, y, t);
		nodeX = x;
		nodeY = y;
	}
	
	public void init() {
		state = 0;
		f = 0;
		g = 0;
		h = 0;
		haveParent = false;
		parentX = 0;
		parentY = 0;
		select = false;
		makeLoad = false;
		obstacle = false;
		repaint();
	}
	
	public void setCorner(boolean corner) {
		this.corner = corner;
	}
	public boolean getCorner() {
		return corner;
	}
	public void setObstacle(boolean obstacle) {
		this.obstacle = obstacle;
	}
	public boolean getObstacle() {
		return obstacle;
	}
	
	public void paintComponent(Graphics g) {
		
		if (type == 1 || type == 2)
			g.setColor(Color.black);
		else
			g.setColor(Color.white);
		
		g.fillRect(0, 0, 19, 19);
		
		if (unitObject) {
			g.setColor(Color.black);
			g.drawLine(5, 5, 15, 15);
			g.drawLine(15, 5, 5, 15);
		}
		
		if (makeLoad) {
			g.setColor(Color.red);
			g.fillOval(5, 5, 10, 10);
		}
		
	}
	
	public void open(int g, int h) {
		state = 1;
		this.g = g;
		this.h = h;
		this.f = g + h;
		repaint();
	}
	
	public void makeLoad() {
		makeLoad = true;
		repaint();
	}
	
	public void select(boolean s) {
		select = s;
		repaint();
	}
	
	public void setState(int s) {
		state = s;
	}
	
	public int getState() {
		return state;
	}
	
	public int getNodeX() {
		return nodeX;
	}
	
	public int getNodeY() {
		return nodeY;
	}
	
	public void setParentX(int parentX) {
		this.parentX = parentX;
	}
	public void setParentY(int parentY) {
		this.parentY = parentY;
	}
	
	public int getF() {
		return f;
	}
	
	public int getG() {
		return g;
	}
	
	public int getH() {
		return h;
	}
	
	public int getParentX() {
		return parentX;
	}
	public int getParentY() {
		return parentY;
	}
	public void setHaveParent(boolean haveParent) {
		this.haveParent = haveParent;
	}
	public boolean getHaveParent() {
		return haveParent;
	}
	
}
