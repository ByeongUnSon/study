package designpattern.gof.abstractfactory.after;

// 우주에서 소년들이 전투를 하는 스테이지에서 생성되는 객체들의 팩토리 클래스
public class SpaceStageFactory extends StageFactory {
	
	public Tree makeTree() {
		return new SpaceTree();
	}
	
	public Car makeCar() {
		return new SpaceCar();
	}
	
	public Bunker makeBunker() {
		return new SpaceBunker();
	}
}
