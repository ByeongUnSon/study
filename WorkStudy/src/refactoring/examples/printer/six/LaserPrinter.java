package refactoring.examples.printer.six;

public class LaserPrinter extends Printer {
	private PrintCartridge cartridge;
	
	public LaserPrinter(String ID) {
		super(ID);
		cartridge = new PrintCartridge(100, 0.2);
	}

	@Override
	public void printing(Object msg) {
		System.out.println("������ ������� ����Ʈ�� �����մϴ�.");
		System.out.println(msg.toString());
		System.out.println("������ ������� ����Ʈ�� �����մϴ�.");
		
		cartridge.consume();
	}

	@Override
	public boolean isPrintable() {
		return cartridge.isAvailable();
	}

	@Override
	public void alert() {
		System.out.println("��ʰ� �����մϴ�. ��� ������ ���ڱ���~");
	}
}
