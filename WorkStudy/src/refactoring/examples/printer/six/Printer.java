package refactoring.examples.printer.six;

public abstract class Printer implements Printable {
	public static final int LASER = 1;
	public static final int INKJET = 2;
	public static final int DOT = 3;
	public static final int COLOR = 4;
	
	private String ID;
	
	public Printer(String ID) {
		this.ID = ID;
	}
	
	public static Printer create(int type, String ID) {
		switch (type) {
			case LASER:
				return new LaserPrinter(ID);
			case INKJET:
				return new InkjetPrinter(ID);
			case DOT:
				return new DotPrinter(ID);
			case COLOR:
				return new ColorPrinter(ID);
		}
		return null;
	}
	
	
	public String getID() {
		return ID;
	}
	
	public void print(Object msg) {
		if (isPrintable()) {
			printing(msg);
		} else
			alert();
	}
	
	abstract public void printing(Object msg);
	abstract public boolean isPrintable();
	abstract public void alert();
	
	public void testPrinting() {
		print("프린트 테스트~");
	}
}

