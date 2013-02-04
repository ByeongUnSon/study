package lcson.loadsearch.test;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Timer;

public class Unit extends Canvas implements ActionListener {

	private static final long serialVersionUID = 1L;

	Node objectNode;
	Node currentNode;
	Vector<Node> wayPoint;
	Graphics2D g2;
	int action = 1;
	double spin;
	int movePoint;
	int count;
	Timer timer;
	int unitX;
	int unitY;
	
	
	Unit (int x, int y, Node currentNode) {
		this.currentNode = currentNode;
		g2 = (Graphics2D) super.getGraphics();
		unitX = x * 20;
		unitY = y * 20;
		setBounds(unitX, unitY, 20, 20);
		wayPoint = new Vector<Node>();
		timer = new Timer(100, this);
	}
	
	
	public void init() {
		wayPoint.clear();
		movePoint = 0;
		action = 1;
		timer.stop();
		count = 0;
	}
	public void startTimer() {
		timer.start();
	}
	public void stopTimer() {
		timer.stop();
	}
	public void addWayPoint(Node node) {
		wayPoint.add(node);
	}
	
	public void paint(Graphics g) {
		if (g2 == null) {
			g2 = (Graphics2D) getGraphics();
			g2.translate(9, 9);
		}
		g.setColor(Color.white);
		g.fillRect(0, 0, 19, 19);
		g.setColor(Color.black);
		if (action == 1 || action == 3) {
			g2.drawRect(-3, -6, 5, 5);
			g2.drawRect(-3, 2, 5, 5);
		} else if (action == 0) {
			g2.drawRect(-6, -6, 5, 5);
			g2.drawRect(1, 2, 5, 5);
		} else if (action == 2) {
			g2.drawRect(1, -6, 5, 5);
			g2.drawRect(-6, 2, 5, 5);
		}
		g2.setColor(Color.blue);
		g2.fillOval(-5, -4, 10, 10);
		g2.setColor(Color.white);
		g2.fillRect(-3, 0, 6, 2);
	}
	
	public void move() {
		Node moveNode = wayPoint.get(movePoint);
		int mX = moveNode.getX();
		int mY = moveNode.getY();
		boolean ooX = false;
		boolean ooY = false;
		if (unitX < mX)
			unitX = unitX + 10;
		else if (unitX > mX)
			unitX = unitX - 10;
		else {
			ooX = true;
		}
		
		if (unitY < mY)
			unitY = unitY + 10;
		else if (unitY > mY)
			unitY = unitY - 10;
		else {
			ooY = true;
		}
		setBounds(unitX, unitY, 19, 19);
		repaint();
		
		if (ooX && ooY) {
			currentNode = moveNode;
			movePoint++;
			if (movePoint == wayPoint.size()) { }
			else
				turn();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (wayPoint.size() > 0 && movePoint < wayPoint.size()) {
			move();
			action++;
			if (action == 4)
				action = 0;
		} else {
			System.out.println("목적지에 도착하였습니다.");
			timer.stop();
		}
	}
	
	public boolean setObjectLocation(Node node) {
		if (node.getType() == 0) {
			if (objectNode != null)
				objectNode.setUnitObject(false);
			objectNode = node;
			node.setUnitObject(true);
			return true;
		} else {
			System.out.println("장애물을 목적지로 설정할 수 없습니다.");
			return false;
		}
	}
	
	public void turn() {
		Node moveNode = wayPoint.get(movePoint);
		int oX = moveNode.getX();
		int oY = moveNode.getY();
		int uX = super.getX();
		int uY = super.getY();
		
		double oldSpin = -1 * spin;
		spin = Math.atan2(oY - uY, oX - uX);
		g2.rotate(oldSpin + spin);
		repaint();
	}
	
	public Node getCurrentNode() {
		return currentNode;
	}
	public Node getObjectNode() {
		return objectNode;
	}
	

}
