package jungsuk.exercise9.eleven;

public class Exercise9_11 {

	/**
	 * 커맨드라인으로 2~9사이의 두 개의 숫자를 받아서 두 숫자사이의 구구단을 출력하는 프로그램을 작성하시오.
		예를 들어 3과 5를 입력하면 3단부터 5단까지 출력한다.
	 */
	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("시작 단과 끝 단, 두 개의 정수를 입력해주세요.\nUSAGE : GugudanTest 3 5");
		} else {
			int start = Integer.parseInt(args[0]);
			int end = Integer.parseInt(args[1]);
			
			for (int i=start; i<=end; i++) {
				for (int j=1; j<=9; j++) {
					System.out.println(i+"*"+j+"="+(i*j));
				}
				System.out.println();
			}
		}
	}

}
