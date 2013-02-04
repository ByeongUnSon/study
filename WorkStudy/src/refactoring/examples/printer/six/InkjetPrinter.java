package refactoring.examples.printer.six;

public class InkjetPrinter extends Printer {
	
	private PrintCartridge cartridge;
	
	public InkjetPrinter(String ID) {
		super(ID);
		cartridge = new PrintCartridge(100, 0.5);
	}
	
	public void printing(Object msg) {
		System.out.println("��ũ�� ������� ����Ʈ�� �����մϴ�.");
		System.out.println(msg.toString());
		System.out.println("��ũ�� ������� ����Ʈ�� �����մϴ�.");
		
		cartridge.consume();
	}
	
	public void alert() {
		System.out.println("��ũ�� �����մϴ�. ���� ������ ���ڱ���~");
	}
	
	public boolean isPrintable() {	// ������ ���� �з��� ����������
		return cartridge.isAvailable();
	}
	
}
