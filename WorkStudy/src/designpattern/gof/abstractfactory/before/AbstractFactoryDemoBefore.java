package designpattern.gof.abstractfactory.before;

import java.util.Enumeration;

public class AbstractFactoryDemoBefore {

	public static void main(String[] args) {
		Stage[] stages = new Stage[2];
		
		// ���� "���ο�" ���������� �����Ѵ�
		stages[0] = createSnowStage();
		
		// �ι�°�� "���ֽο�" ���������� �����Ѵ�
		stages[1] = createSpaceStage();
		for (int i=0; i<stages.length; i++) {
			Enumeration components = stages[i].getStageComponents();
			
			while (components.hasMoreElements()) {
				StageComponent component = (StageComponent) components.nextElement();
				component.draw();
			}
			
			System.out.println("");
		}
	}
	// "���ο�" ���������� �ʱ�ȭ���� �����Ѵ�
	// ��Ŀ�� 2��, �ڵ����� 2��, ���� 1�׷羿 ��ġ�Ѵ�
	static Stage createSnowStage() {
		Stage stage = new Stage();
		
		// ���� 1�׷� ��ġ�Ѵ�
		Tree tree = new SnowTree();
		tree.setX(50);
		tree.setY(50);
		stage.addStageComponent(tree);
		
		// �ڵ��� 2�븦 �����Ѵ�
		Car car = new SnowCar();
		car.setX(10);
		car.setY(10);
		stage.addStageComponent(car);
		car = new SnowCar();
		car.setX(10);
		car.setY(20);
		stage.addStageComponent(car);
		
		// ��Ŀ 2�븦 �����Ѵ�
		Bunker bunker = new SnowBunker();
		bunker.setX(60);
		bunker.setY(30);
		stage.addStageComponent(bunker);
		bunker = new SnowBunker();
		bunker.setX(60);
		bunker.setY(40);
		stage.addStageComponent(bunker);
		
		return stage;		
	}
	
	
	// "���ֽο�" �ʱ�ȭ���� �����Ѵ�
	// ��Ŀ�� 2��, �ڵ����� 2��, ���� 1�׷羿 ��ġ�Ѵ�
	
	static Stage createSpaceStage() {
		Stage stage = new Stage();
		
		// ���� 1�׷� ��ġ�Ѵ�
		Tree tree = new SpaceTree();
		tree.setX(50);
		tree.setY(50);
		stage.addStageComponent(tree);
		
		// �ڵ��� 2�븦 �����Ѵ�
		Car car = new SpaceCar();
		car.setX(10);
		car.setY(10);
		stage.addStageComponent(car);
		car = new SpaceCar();
		car.setX(10);
		car.setY(20);
		stage.addStageComponent(car);
		
		// ��Ŀ 2�븦 �����Ѵ�
		Bunker bunker = new SpaceBunker();
		bunker.setX(60);
		bunker.setY(30);
		stage.addStageComponent(bunker);
		bunker = new SpaceBunker();
		bunker.setX(60);
		bunker.setY(40);
		stage.addStageComponent(bunker);
		return stage;
	}

}
