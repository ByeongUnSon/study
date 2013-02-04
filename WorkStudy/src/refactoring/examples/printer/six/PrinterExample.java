package refactoring.examples.printer.six;

public class PrinterExample {

	public static void main(String[] args) {
		Printer iPrinter = Printer.create(Printer.INKJET, "101");
		Printer dPrinter = Printer.create(Printer.DOT, "102");
		Printer lPrinter = Printer.create(Printer.LASER, "103");
		Printer cPrinter = Printer.create(Printer.COLOR, "104");
		PDFWriter pWriter = new PDFWriter("Test.pdf");
		
		printWelcome(iPrinter);
		printWelcome(dPrinter);
		printWelcome(lPrinter);
		printWelcome(cPrinter);
		printWelcome(pWriter);

		
	}
	public static void printWelcome(Printable printableObject) {
		printableObject.print("ȯ���մϴ�. �����͸� �׽�Ʈ���Դϴ�.");
		System.out.println("");
	}
}
