package jungsuk.exercise14.six;

import java.io.*;
import java.util.*;

class Exercise14_6 {
	static String[] argArr; // 입력한 매개변수를 담기위한 문자열배열
	static File curDir; // 현재 디렉토리
	static {
		try {
			curDir = new File(System.getProperty("user.dir"));
		} catch (Exception e) { }
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		while (true) {
			
			try {
				String prompt = curDir.getCanonicalPath() + ">>";
				System.out.print(prompt);				
				// 화면으로부터 라인단위로 입력받는다.
				String input = s.nextLine();
				input = input.trim(); // 입력받은 값에서 불필요한 앞뒤 공백을 제거한다.
				argArr = input.split(" +");
				
				String command = argArr[0].trim();
				
				if ("".equals(command))
					continue;
				
				command = command.toLowerCase(); // 명령어를 소문자로 바꾼다.
				if (command.equals("q")) { // q 또는 Q를 입력하면 실행종료한다.
					System.out.println("프로그램을 종료합니다...");
					System.exit(0);
				} else if (command.equals("cd")) {
					cd();
				} else if (command.equals("dir")) {
					dir();
				} else {
					for (int i = 0; i < argArr.length; i++) {
						System.out.println(argArr[i]);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("입력오류입니다.");
			}
		} // while(true)
	} // main
	
	public static void dir() {
		
		File[] files = curDir.listFiles();
		
		for (int i=0; i<files.length; i++) {
			System.out.println(files[i]);
		}		
	}
		
	public static void cd() {
		if (argArr.length == 1) {
			System.out.println(curDir);
			return;
		} else if (argArr.length > 2) {
			System.out.println("USAGE : cd directory");
			return;
		}
		String subDir = argArr[1];

		if ("..".equals(subDir)) {
			
			File newDir = curDir.getParentFile();
		
			if (newDir == null) {
				System.out.println("유효하지 않은 디렉토리입니다.");
			} else {
				curDir = newDir; // 조상 디렉토리를 현재 디렉토리로 지정
			}
		} else if (".".equals(subDir)) {
			System.out.println(curDir);
		} else {
			File newDir = new File(curDir, subDir);		
			
			if (newDir.exists() && newDir.isDirectory()) {
				curDir = newDir;
			} else {
				System.out.println("유효하지 않은 디렉토리입니다.");
			}
		}
	} // cd()
}