package designpattern.gof.abstractfactory.after;

// ���ֿ��� �ҳ���� ������ �ϴ� ������������ �����Ǵ� ��ü���� ���丮 Ŭ����
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
