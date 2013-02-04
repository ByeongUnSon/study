package designpattern.gof.abstractfactory.before;

import java.util.Enumeration;

public class AbstractFactoryDemoBefore {

	public static void main(String[] args) {
		Stage[] stages = new Stage[2];
		
		// 먼저 "눈싸움" 스테이지를 생성한다
		stages[0] = createSnowStage();
		
		// 두번째로 "우주싸움" 스테이지를 생성한다
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
	// "눈싸움" 스테이지의 초기화면을 구성한다
	// 벙커가 2개, 자동차가 2대, 나무 1그루씩 배치한다
	static Stage createSnowStage() {
		Stage stage = new Stage();
		
		// 나무 1그루 배치한다
		Tree tree = new SnowTree();
		tree.setX(50);
		tree.setY(50);
		stage.addStageComponent(tree);
		
		// 자동차 2대를 포함한다
		Car car = new SnowCar();
		car.setX(10);
		car.setY(10);
		stage.addStageComponent(car);
		car = new SnowCar();
		car.setX(10);
		car.setY(20);
		stage.addStageComponent(car);
		
		// 벙커 2대를 포함한다
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
	
	
	// "우주싸움" 초기화면을 구성한다
	// 벙커가 2개, 자동차가 2대, 나무 1그루씩 배치한다
	
	static Stage createSpaceStage() {
		Stage stage = new Stage();
		
		// 나무 1그루 배치한다
		Tree tree = new SpaceTree();
		tree.setX(50);
		tree.setY(50);
		stage.addStageComponent(tree);
		
		// 자동차 2대를 포함한다
		Car car = new SpaceCar();
		car.setX(10);
		car.setY(10);
		stage.addStageComponent(car);
		car = new SpaceCar();
		car.setX(10);
		car.setY(20);
		stage.addStageComponent(car);
		
		// 벙커 2대를 포함한다
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
