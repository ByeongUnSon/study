package designpattern.gof.abstractfactory.after;

// 눈싸움 스테이지에 나타나는 자동차들을 상징한다
public class SnowCar extends Car {
	
	public void draw() {
		// 화면에 눈 자동차를 그린다
		
		System.out.println("(" + x + "," + y +")에 있는 눈자동차의 모습");
	}
	
	// "눈자동차" 관련 기타 메서드들
}
