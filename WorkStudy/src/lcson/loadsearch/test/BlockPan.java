package lcson.loadsearch.test;

import javax.swing.JLayeredPane;

public class BlockPan extends JLayeredPane {

	private static final long serialVersionUID = 1L;

	public void addBlock(Block block) {
		add(block, new Integer(0));
	}
	
	public void addUnit(Unit unit) {
		add(unit, new Integer(100));
	}
}
