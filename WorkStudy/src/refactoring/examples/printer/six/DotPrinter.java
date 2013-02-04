package refactoring.examples.printer.six;

public class DotPrinter extends Printer {
	
	private PrintCartridge cartridge;
	
	public DotPrinter(String ID) {
		super(ID);
		cartridge = new PrintCartridge(100, 0.1);
	}
	
	public void printing(Object msg) {
		System.out.println("��Ʈ ������� ����Ʈ�� �����մϴ�.");
		System.out.println(msg.toString());
		System.out.println("��Ʈ ������� ����Ʈ�� �����մϴ�.");
		
		cartridge.consume();
	}
	
	public void alert() {
		System.out.println("��Ʈ�� �����մϴ�. ���� ������ ���ڱ���~");
	}
	
	public boolean isPrintable() {
		return true;
	}

}
