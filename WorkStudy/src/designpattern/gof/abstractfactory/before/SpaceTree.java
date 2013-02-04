package designpattern.gof.abstractfactory.before;

// 우주전사 싸움 스테이지에 나타나는 나무들을 상징한다
public class SpaceTree extends Tree {
	
	public void draw() {
		// 화면에 우주나무를 그린다
		System.out.println("(" + x + "," + y + ")에 있는 우주 나무의 모습");
	}
	
	// 우주 나무 관련 기타 메서드들
}
