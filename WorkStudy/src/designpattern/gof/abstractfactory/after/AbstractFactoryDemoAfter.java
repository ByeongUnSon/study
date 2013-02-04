package designpattern.gof.abstractfactory.after;

import java.util.Enumeration;

public class AbstractFactoryDemoAfter {

	public static void main(String[] args) { // ������ �ΰ��� ���������� �ִٰ� ����
		
		StageFactory[] stageFactories = new StageFactory[2];
		
		// ù��° ���������� "���ο�" ���������� ������ִ� ���丮
		stageFactories[0] = new SnowStageFactory();
		
		// �ι�° ���������� "���ֽο�" ���������� ������ִ� ���丮
		stageFactories[1] = new SpaceStageFactory();
		
		// �� ���������� �����ϰ� ������ �����Ѵ�
		for (int i=0; i<stageFactories.length; i++) {
			// ���� �� ���������� �����Ѵ�
			Stage eachStage = createStage(stageFactories[i]);
			
			// ȭ�鿡 ���������� ���� ������Ʈ���� �׸���
			Enumeration<Object> components = eachStage.getStageComponents();
			
			while (components.hasMoreElements()) {
				StageComponent component = (StageComponent) components.nextElement();
				component.draw();
			}
			
			System.out.println("");
		}
		
		
	}
	
	// �� ���������� ������ �����ϴ� ���� ��ü �� �޼������ �����Ѵ�
	// ...
	
	
	// �� ���������� �ʱ� ȭ���� �����Ѵ�
	// ��Ŀ�� 2��, �ڵ����� 2��, ���� 1�׷羿 ��ġ�Ѵ�
	static Stage createStage(StageFactory factory) {
		Stage stage = new Stage();
		
		// ���� 1�׷羿 ��ġ�Ѵ�
		Tree tree = factory.makeTree();
		tree.setX(50);
		tree.setY(50);
		stage.addStageComponent(tree);
		
		// �ڵ��� 2�븦 �����Ѵ�
		Car car = factory.makeCar();
		car.setX(10);
		car.setY(10);
		stage.addStageComponent(car);
		car = factory.makeCar();
		car.setX(10);
		car.setY(10);
		stage.addStageComponent(car);
		
		// ��Ŀ 2�븦 �����Ѵ�
		Bunker bunker = factory.makeBunker();
		bunker.setX(60);
		bunker.setY(30);
		stage.addStageComponent(bunker);
		bunker.setX(60);
		bunker.setY(40);
		stage.addStageComponent(bunker);
		
		return stage;
	}

}
