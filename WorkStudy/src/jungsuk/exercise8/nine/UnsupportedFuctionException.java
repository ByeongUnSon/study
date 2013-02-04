package jungsuk.exercise8.nine;

public class UnsupportedFuctionException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private final int ERR_CODE;
		
	public UnsupportedFuctionException(String message) {
		this(message, 100);
	}
	
	public UnsupportedFuctionException(String message, int e_code) {
		super(message);
		this.ERR_CODE = e_code;
	}
		
	public int getErrorCode() {
		return ERR_CODE;
	}
	
	@Override
	public String getMessage() {
		return "[" + getErrorCode() + "] " + super.getMessage();
	}
	
	
}
