package jungsuk.exercise14.three;

import java.io.File;

public class Exercise14_3 {
	static int totalFiles = 0;
	static int totalDirs = 0;
	static int totalSize = 0;

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE : java Exercise14_3 DIRECTORY");
			System.exit(0);
		}
		File dir = new File(args[0]);
		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("��ȿ���� ���� ���丮�Դϴ�.");
			System.exit(0);
		}
		countFiles(dir);
		System.out.println();
		System.out.println("�� " + totalFiles + "���� ����");
		System.out.println("�� " + totalDirs + "���� ���丮");
		System.out.println("ũ�� " + totalSize + " bytes");
	} // main

	public static void countFiles(File dir) {
		/*
		 * (1) �Ʒ��� ������ �°� �ڵ带 �ۼ��Ͻÿ�. 1. dir�� ���ϸ��(File[])�� ���´�. 2. ���� ���ϸ���� ����
		 * �߿���... ���丮�̸�, totalDirs�� ���� ������Ű�� countFiles()�� ���ȣ���Ѵ�. 3. �����̸�,
		 * totlaFiles�� ������Ű�� ������ ũ�⸦ totalSize�� ���Ѵ�.
		 */	
		File[] files = dir.listFiles();
		
		for (int i=0; i<files.length; i++) {
			if (files[i].isDirectory()) {
				totalDirs++;
				countFiles(files[i]);
			} else {
				totalFiles++;
				totalSize += files[i].length();
			}
		}
		
	} // countFiles
}