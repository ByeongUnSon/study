package designpattern.gof.abstractfactory.after;

// ������ �ҳ���� ���ο��� �ϴ� ������������ �����Ǵ� ��ü���� ���丮 Ŭ����
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
