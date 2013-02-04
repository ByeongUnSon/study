package designpattern.gof.abstractfactory.after;

import java.util.Enumeration;
import java.util.Vector;

public class Stage {
	Vector<Object> stageComponents;
	
	public Stage() {
		stageComponents= new Vector<Object>();
	}
	
	// ���������� �ҳ�� ������������ ���� ������Ʈ���� ���Խ�Ų��
	public void addStageComponent(StageComponent stageComponent) {
		stageComponents.addElement(stageComponent);
	}
	
	// ���� ���������ȿ� ���ԵǾ� �ִ� ��� ���� ������Ʈ���� ��ȯ�Ѵ�
	public Enumeration<Object> getStageComponents() {
		return stageComponents.elements();
	}
	
}
