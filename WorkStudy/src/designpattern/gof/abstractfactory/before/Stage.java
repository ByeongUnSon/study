package designpattern.gof.abstractfactory.before;

import java.util.Enumeration;
import java.util.Vector;

public class Stage {
	Vector stageComponents;
	
	public Stage() {
		stageComponents = new Vector();
	}
	
	// 스테이지에 소년과 지형지물등의 게임 컴포넌트들을 포함시킨다
	public void addStageComponent(StageComponent stageComponent) {
		stageComponents.addElement(stageComponent);
	}
	
	// 현재 스테이지안에 포함되어 있는 모든 게임 컴포넌트들을 반환한다
	public Enumeration getStageComponents() {
		return stageComponents.elements();
	}
}
