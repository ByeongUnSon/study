package refactoring.examples.printer.six;

public class PrintCartridge {
	private double capacity;
	private double reductionRate;
	
	public PrintCartridge(double capacity, double reductionRate) {
		this.capacity = capacity;
		this.reductionRate = reductionRate;
	}
	
	public boolean isAvailable() {
		return capacity - reductionRate > 0;
	}
	
	public void consume() {
		capacity -= reductionRate;
	}
	
	public double getCapacity() {
		return capacity;
	}

}
