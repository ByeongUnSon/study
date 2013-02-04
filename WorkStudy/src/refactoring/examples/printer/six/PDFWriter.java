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
		System.out.println("문서내용을 " + fileName + " 파일에 PDF 포맷으로 출력하기 시작합니다.");
		System.out.println(document);
		System.out.println("문서내용을 " + fileName + " 파일에 PDF 포맷으로 출력을 완료했습니다.");
	}
}
