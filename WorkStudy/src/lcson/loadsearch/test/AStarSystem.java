package lcson.loadsearch.test;

import java.util.Stack;
import java.util.Vector;

public class AStarSystem {

	Node[][] node;
	Node startNode;
	Node endNode;
	Node minyNode;
	Vector<Node> openVec;
	Vector<Node> okNode;
	Unit unit;
	
	AStarSystem (Node[][] n) {
		node = n;
		openVec = new Vector<Node>();
		okNode = new Vector<Node>();
	}
	
	public void init() {
		openVec.clear();
		okNode.clear();
	}
	
	public void searchWay(Unit unit) {
		this.unit = unit;
		initNode();
		unit.init();
		this.init();
		startNode = unit.getCurrentNode();
		endNode = unit.getObjectNode();
		minyNode = startNode;
		while (endNode != minyNode) {
			aroundOpen(minyNode);
		}
		makeLoad();
	}
	
	public int open(Node oNode) {
		int g = getG(oNode);
		int h = getH(oNode);
		oNode.open(g, h);
		return g + h;
	}
	
	public Node getEndNode() {
		return endNode;
	}
	
	public void makeLoad() {
		Node imsiNode=  endNode;
		Stack<Node> imsiStack = new Stack<Node>();
		while (imsiNode != startNode) {
			imsiNode.makeLoad();
			imsiStack.push(imsiNode);
			int pI = imsiNode.getParentX();
			int pJ = imsiNode.getParentY();
			imsiNode = node[pI][pJ];
		}
		for ( ; true != imsiStack.isEmpty() ; ) {
			unit.addWayPoint((Node) imsiStack.pop());
		}
		unit.startTimer();
	}
	
	public int getG(Node oNode) {
		int g = 0;
		Node gNode = oNode;
		while (startNode != gNode) {
			Node parentNode = node[gNode.getParentX()][gNode.getParentY()];
			int pX = parentNode.getNodeX();
			int pY = parentNode.getNodeY();
			
			int x = gNode.getNodeX();
			int y = gNode.getNodeY();
			
			if (x == pX)
				g+=10;
			else if (y == pY)
				g+=10;
			else
				g+=14;
			gNode = parentNode;
		}
		return g;
	}
	
	public int getH(Node oNode) {
		int h = 0;
		int x = oNode.getNodeX();
		int y = oNode.getNodeY();
		int eX = endNode.getNodeX();
		int eY = endNode.getNodeY();
		int xCount = 0;
		int yCount = 0;
		while (x != eX) {
			if (x > eX)
				x-=1;
			else if (x < eY)
				x+=1;
			else {
				
			}
			xCount++;
		}
		while (y != eY) {
			if (y > eY)
				y-=1;
			else if (y < eY)
				y+=1;
			else {
				
			}
			yCount++;
		}
		h = xCount * 10 + yCount * 10;
		
		return h;
	}
	
	public void cornerAvoid(Node[] avoid) {
		for (int i=0; i<avoid.length; i++) {
			avoid[i].setCorner(false);
		}
		if (avoid[1].getType() != 0) {// i-1 
			avoid[0].setCorner(true);
			avoid[2].setCorner(true);
		}
		if (avoid[3].getType() != 0) {
			avoid[0].setCorner(true);
			avoid[5].setCorner(true);
		}
		if (avoid[4].getType() != 0) {
			avoid[2].setCorner(true);
			avoid[7].setCorner(true);
		}
		if (avoid[6].getType() != 0) {
			avoid[5].setCorner(true);
			avoid[7].setCorner(true);
		}
	}
	
	public Node aroundOpen(Node selectNode) {
		int i = selectNode.getNodeX();
		int j = selectNode.getNodeY();
		
		Node aNode[] = new Node[8];
		aNode[0] = node[i-1][j-1];
		aNode[1] = node[i-1][j];
		aNode[2] = node[i-1][j+1];
		aNode[3] = node[i][j-1];
		aNode[4] = node[i][j+1];
		aNode[5] = node[i+1][j-1];
		aNode[6] = node[i+1][j];
		aNode[7] = node[i+1][j+1];
		cornerAvoid(aNode);
		
		for (int ii=0; ii<8; ii++) {
			
			if (aNode[ii].getType() == 0) {
				
				if (aNode[ii].getCorner() == false) {
					
					if (aNode[ii].getState() == 0) {
						
						aNode[ii].setHaveParent(true);
						aNode[ii].setParentX(i);
						aNode[ii].setParentY(j);
						int g = getG(aNode[ii]);
						int h = getH(aNode[ii]);
						aNode[ii].open(g, h);
						openVec.add(aNode[ii]);
					} else if (aNode[ii].getState() == 1) {
						int oldG = aNode[ii].getG();
						int oldH = aNode[ii].getH();
						int oldPI = aNode[ii].getParentX();
						int oldPJ = aNode[ii].getParentY();
						aNode[ii].setParentX(i);
						aNode[ii].setParentY(j);
						int newG = getG(aNode[ii]);
						if (oldG < newG) {
							aNode[ii].setParentX(oldPI);
							aNode[ii].setParentY(oldPJ);
						} else {
							aNode[ii].open(newG, oldH);
						}
					} else {
						System.out.println("Node[" + aNode[ii].getNodeX() +"][" + aNode[ii].getNodeY() + "] 는 닫힌상태이므로 열수가 없습니다.");
					}
				}
			} else {
				System.out.println("Node[" + aNode[ii].getNodeX() + "][" + aNode[ii].getNodeY() + "] 는 장애물이라 열 수 없습니다.");
			}
		}
		openVec.remove(selectNode);
		selectNode.setState(2);
		
		int mini = 0;
		
		for (int i1=0; i1 < openVec.size(); i1++) {
			if (openVec.get(mini).getF() >= openVec.get(i1).getF())
				mini = i1;
		}
		
		try {
			minyNode = openVec.get(mini);
			minyNode.select(true);
		} catch (Exception e) {
			initNode();
			unit.init();
			this.init();
			System.out.println("갈 수 없는 곳을 클릭하였습니다.");
		}
		return minyNode;
	}
	
	public void initNode() {
		startNode = null;
		endNode = null;
		minyNode = null;
		openVec.clear();
		
		for (int i = 0; i < 20; i++) {
			for (int j =0; j< 20; j++) {
				node[i][j].init();
			}
		}
		
	}
	
	public Node getMinyNode() {
		return minyNode;
	}
}
