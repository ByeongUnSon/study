package designpattern.gof.abstractfactory.after;

public class SnowTree extends Tree {

	public void draw() {
		// 화면에 우주 나무를 그린다
		
		System.out.println("(" + x + "," + y +")에 있는 눈나무의 모습");
	}
	
	// "우주" 관련 기타 메서드들
}
