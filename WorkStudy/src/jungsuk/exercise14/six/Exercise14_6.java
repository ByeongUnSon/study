package jungsuk.exercise14.six;

import java.io.*;
import java.util.*;

class Exercise14_6 {
	static String[] argArr; // �Է��� �Ű������� ������� ���ڿ��迭
	static File curDir; // ���� ���丮
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
				// ȭ�����κ��� ���δ����� �Է¹޴´�.
				String input = s.nextLine();
				input = input.trim(); // �Է¹��� ������ ���ʿ��� �յ� ������ �����Ѵ�.
				argArr = input.split(" +");
				
				String command = argArr[0].trim();
				
				if ("".equals(command))
					continue;
				
				command = command.toLowerCase(); // ��ɾ �ҹ��ڷ� �ٲ۴�.
				if (command.equals("q")) { // q �Ǵ� Q�� �Է��ϸ� ���������Ѵ�.
					System.out.println("���α׷��� �����մϴ�...");
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
				System.out.println("�Է¿����Դϴ�.");
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
				System.out.println("��ȿ���� ���� ���丮�Դϴ�.");
			} else {
				curDir = newDir; // ���� ���丮�� ���� ���丮�� ����
			}
		} else if (".".equals(subDir)) {
			System.out.println(curDir);
		} else {
			File newDir = new File(curDir, subDir);		
			
			if (newDir.exists() && newDir.isDirectory()) {
				curDir = newDir;
			} else {
				System.out.println("��ȿ���� ���� ���丮�Դϴ�.");
			}
		}
	} // cd()
}