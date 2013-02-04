package jungsuk.exercise14.one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise14_1 {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.err.println("USAGE: java Exercise14_1 10 FILENAME");
		} else {
			int line = Integer.parseInt(args[0]);
			String fileName = args[1];

			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(fileName));
				for (int i=0; i<line; i++) 
				System.out.println(i+1 + ":" + br.readLine());
			
			} catch (IOException e) {
				System.out.println(fileName + "는 디렉토리이거나, 존재하지 않는 파일입니다.");
			}

		}
	}

}
