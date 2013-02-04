package designpattern.gof.abstractfactory.after;

// 우주전사 싸움 스테이지에 나타나는 자동차들을 상징한다
public class SpaceCar extends Car {
	
	public void draw() {
		
		System.out.println("(" + x + "," + y +")에 있는 우주자동차의 모습");
	}
	
	// "우주 자동차" 관련 기타 메서드들
	//
}
