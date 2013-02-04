package designpattern.gof.abstractfactory.before;

// 눈싸움 스테이지에 나타나는 나무들을 상징한다
public class SnowTree extends Tree {
	public void draw() {
		// 화면에 눈 나무를 그린다
		System.out.println("(" + x + "," + y + ")에 있는 눈 나무의 모습");
	}
	
	// "눈나무" 관련 기타 메서드들
}
