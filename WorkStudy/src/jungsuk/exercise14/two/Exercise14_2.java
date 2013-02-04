package jungsuk.exercise14.two;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Exercise14_2 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		if (args.length != 1) {
			System.err.println("java Exercise14_2 Exercise14_2.class");
		} else {

			String inputFile = args[0];
			int data = 0;
			int i = 0;
			FileInputStream input = new FileInputStream(inputFile);
			PrintStream output = new PrintStream(System.out);

			while ((data = input.read()) != -1) {
				output.printf("%02x ", data);
				if (++i % 16 == 0)
					output.println();
			}
			input.close();
			output.close();
		}
	}

}
