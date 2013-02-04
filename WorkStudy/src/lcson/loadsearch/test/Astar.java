package lcson.loadsearch.test;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Astar implements MouseListener {

	AStarSystem astarSystem;
	Node[][] nodes;
	Unit unit;
	
	Astar() {
		nodes = new Nodes().makeNode();
		astarSystem = new AStarSystem(nodes);
	}
	
	public void init()	 {
		JFrame frame = new JFrame("A* 길찾기 테스트");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BlockPan blockPan = new BlockPan();
		
		for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++) {
				blockPan.add(nodes[i][j]);
			}
		}
		unit = new Unit(10, 10, nodes[10][10]);
		blockPan.addUnit(unit);
		blockPan.addMouseListener(this);
		Container con = frame.getContentPane();
		con.add(blockPan);
		frame.setBounds(50, 50, 410, 435);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public void mouseClicked(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mousePressed(MouseEvent e) {
		int btnNum = e.getButton();
		int j = e.getX() / 20;
		int i = e.getY() / 20;
		if (j < 20 && i < 20) {
			if (btnNum == 1)
			{
				boolean tf = unit.setObjectLocation(nodes[i][j]);
				if (tf){
					astarSystem.searchWay(unit);					
				}
			}
			else if (btnNum == 2)
			{
				//astarSystem.aroundOpen(astarSystem.getMinyNode());
				if (astarSystem.getEndNode() == astarSystem.getMinyNode())
				{
					astarSystem.makeLoad();
				}
				else
					astarSystem.aroundOpen(astarSystem.getMinyNode());
			}
			else if (btnNum == 3)
			{
				nodes[i][j].changeType();
				if (unit.getObjectNode() != null)
					astarSystem.searchWay(unit);				
			}
		} else
			System.out.println("목적지를 벗어난 지역을 선택하였습니다.");
	}
	public void mouseReleased(MouseEvent  e) { }

	public static void main(String[] args) {
		Astar a =  new Astar();
		a.init();
	}

}
