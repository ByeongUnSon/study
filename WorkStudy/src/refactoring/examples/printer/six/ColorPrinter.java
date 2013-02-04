package refactoring.examples.printer.six;

public class ColorPrinter extends Printer {
	
	private PrintCartridge cartridge;
	
	public ColorPrinter(String ID) {
		super(ID);
		cartridge = new PrintCartridge(100, 0.3);
	}

	@Override
	public void printing(Object msg) {
		System.out.println("컬러 방식으로 프린트를 시작합니다.");
		System.out.println(msg.toString());
		System.out.println("컬러 방식으로 프린트를 종료합니다.");
		cartridge.consume();
	}

	@Override
	public boolean isPrintable() {
		return cartridge.isAvailable();
	}

	@Override
	public void alert() {
		System.out.println("컬러잉크가 부족합니다. 빨간램프가 깜박 깜박~");
	}
}
