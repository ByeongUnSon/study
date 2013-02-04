package designpattern.gof.abstractfactory.before;

import java.util.Enumeration;
import java.util.Vector;

public class Stage {
	Vector stageComponents;
	
	public Stage() {
		stageComponents = new Vector();
	}
	
	// ���������� �ҳ�� ������������ ���� ������Ʈ���� ���Խ�Ų��
	public void addStageComponent(StageComponent stageComponent) {
		stageComponents.addElement(stageComponent);
	}
	
	// ���� ���������ȿ� ���ԵǾ� �ִ� ��� ���� ������Ʈ���� ��ȯ�Ѵ�
	public Enumeration getStageComponents() {
		return stageComponents.elements();
	}
}
