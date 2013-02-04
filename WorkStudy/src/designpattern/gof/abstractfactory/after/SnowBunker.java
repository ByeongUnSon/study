package designpattern.gof.abstractfactory.after;

// 눈싸움 스테이지에 나타나는 눈벙커를 상징한다
public class SnowBunker extends Bunker {
	
	public void draw() {
		// 화면에 눈벙커를 그린다
		
		System.out.println("(" + x + "," + y +")에 있는 눈벙커의 모습");
	}
	
	// "눈벙커" 관련 기타 메서드들
}
