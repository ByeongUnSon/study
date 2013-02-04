package refactoring.examples.printer.six;

public class LaserPrinter extends Printer {
	private PrintCartridge cartridge;
	
	public LaserPrinter(String ID) {
		super(ID);
		cartridge = new PrintCartridge(100, 0.2);
	}

	@Override
	public void printing(Object msg) {
		System.out.println("레이저 방식으로 프린트를 시작합니다.");
		System.out.println(msg.toString());
		System.out.println("레이저 방식으로 프린트를 종료합니다.");
		
		cartridge.consume();
	}

	@Override
	public boolean isPrintable() {
		return cartridge.isAvailable();
	}

	@Override
	public void alert() {
		System.out.println("토너가 부족합니다. 노란 램프를 깜박깜박~");
	}
}
