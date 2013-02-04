package designpattern.gof.abstractfactory.after;

// 지구의 소년들이 눈싸움을 하는 스테이지에서 생성되는 객체들의 팩토리 클래스
public class SnowStageFactory extends StageFactory {
	
	public Tree makeTree() {
		return new SnowTree();
	}
	
	public Car makeCar() {
		return new SnowCar();
	}
	
	public Bunker makeBunker() {
		return new SnowBunker();
	}
}
