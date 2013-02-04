package refactoring.examples.printer.six;

public class ColorPrinter extends Printer {
	
	private PrintCartridge cartridge;
	
	public ColorPrinter(String ID) {
		super(ID);
		cartridge = new PrintCartridge(100, 0.3);
	}

	@Override
	public void printing(Object msg) {
		System.out.println("�÷� ������� ����Ʈ�� �����մϴ�.");
		System.out.println(msg.toString());
		System.out.println("�÷� ������� ����Ʈ�� �����մϴ�.");
		cartridge.consume();
	}

	@Override
	public boolean isPrintable() {
		return cartridge.isAvailable();
	}

	@Override
	public void alert() {
		System.out.println("�÷���ũ�� �����մϴ�. ���������� ���� ����~");
	}
}
