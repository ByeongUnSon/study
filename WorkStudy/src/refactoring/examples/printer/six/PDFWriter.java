package refactoring.examples.printer.six;

public class PDFWriter implements Printable {
	private String fileName;
	
	public PDFWriter(String fileName) {
		this.fileName = fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void print(Object document) {
		System.out.println("���������� " + fileName + " ���Ͽ� PDF �������� ����ϱ� �����մϴ�.");
		System.out.println(document);
		System.out.println("���������� " + fileName + " ���Ͽ� PDF �������� ����� �Ϸ��߽��ϴ�.");
	}
}
