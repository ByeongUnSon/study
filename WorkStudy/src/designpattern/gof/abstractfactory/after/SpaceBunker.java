package designpattern.gof.abstractfactory.after;

public class SpaceBunker extends Bunker {
	
	public void draw() {
		// 화면에 우주벙커를 그린다
		
		System.out.println("(" + x + "," + y +")에 있는 우주벙커의 모습");
	}
	
	// "우주벙커" 관련 기타 메서드들
}
