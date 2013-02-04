package designpattern.gof.abstractfactory.after;

public abstract class StageFactory {
	
	abstract public Tree makeTree();
	abstract public Car makeCar();
	abstract public Bunker makeBunker();
}
