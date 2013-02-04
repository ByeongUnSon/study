package designpattern.gof.abstractfactory.after;

import java.util.Enumeration;

public class AbstractFactoryDemoAfter {

	public static void main(String[] args) { // 게임은 두개의 스테이지가 있다고 가정
		
		StageFactory[] stageFactories = new StageFactory[2];
		
		// 첫번째 스테이지인 "눈싸움" 스테이지를 만들어주는 팩토리
		stageFactories[0] = new SnowStageFactory();
		
		// 두번째 스테이지인 "우주싸움" 스테이지를 만들어주는 팩토리
		stageFactories[1] = new SpaceStageFactory();
		
		// 각 스테이지를 생성하고 게임을 진행한다
		for (int i=0; i<stageFactories.length; i++) {
			// 먼저 각 스테이지를 생성한다
			Stage eachStage = createStage(stageFactories[i]);
			
			// 화면에 스테이지의 게임 컴포넌트들을 그린다
			Enumeration<Object> components = eachStage.getStageComponents();
			
			while (components.hasMoreElements()) {
				StageComponent component = (StageComponent) components.nextElement();
				component.draw();
			}
			
			System.out.println("");
		}
		
		
	}
	
	// 각 스테이지의 게임을 진행하는 각종 객체 및 메서드들을 구현한다
	// ...
	
	
	// 각 스테이지의 초기 화면을 구성한다
	// 벙커가 2개, 자동차가 2대, 나무 1그루씩 배치한다
	static Stage createStage(StageFactory factory) {
		Stage stage = new Stage();
		
		// 나무 1그루씩 배치한다
		Tree tree = factory.makeTree();
		tree.setX(50);
		tree.setY(50);
		stage.addStageComponent(tree);
		
		// 자동차 2대를 포함한다
		Car car = factory.makeCar();
		car.setX(10);
		car.setY(10);
		stage.addStageComponent(car);
		car = factory.makeCar();
		car.setX(10);
		car.setY(10);
		stage.addStageComponent(car);
		
		// 벙커 2대를 포함한다
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
