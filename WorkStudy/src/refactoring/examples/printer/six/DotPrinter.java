package refactoring.examples.printer.six;

public class DotPrinter extends Printer {
	
	private PrintCartridge cartridge;
	
	public DotPrinter(String ID) {
		super(ID);
		cartridge = new PrintCartridge(100, 0.1);
	}
	
	public void printing(Object msg) {
		System.out.println("도트 방식으로 프린트를 시작합니다.");
		System.out.println(msg.toString());
		System.out.println("도트 방식으로 프린트를 종료합니다.");
		
		cartridge.consume();
	}
	
	public void alert() {
		System.out.println("도트가 부족합니다. 빨간 램프를 깜박깜박~");
	}
	
	public boolean isPrintable() {
		return true;
	}

}
