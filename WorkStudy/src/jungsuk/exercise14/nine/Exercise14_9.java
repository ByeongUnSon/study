package jungsuk.exercise14.nine;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Exercise14_9 extends Frame {
	String fileName;
	TextArea content;
	MenuBar mb;
	Menu mFile;
	MenuItem miNew, miOpen, miSaveAs, miExit;

	Exercise14_9(String title) {
		super(title);
		content = new TextArea();
		add(content);
		mb = new MenuBar();
		mFile = new Menu("File");
		miNew = new MenuItem("New");
		miOpen = new MenuItem("Open");
		miSaveAs = new MenuItem("Save As...");
		miExit = new MenuItem("Exit");
		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(miSaveAs);
		mFile.addSeparator(); // �޴� �и���(separator)�� �ִ´�.
		mFile.add(miExit);
		mb.add(mFile); // MenuBar�� Menu�� �߰��Ѵ�.
		setMenuBar(mb); // Frame�� MenuBar�� ���Խ�Ų��.
		// �޴��� �̺�Ʈ �ڵ鷯�� ����Ѵ�.
		MyHandler handler = new MyHandler();
		miNew.addActionListener(handler);
		miOpen.addActionListener(handler);
		miSaveAs.addActionListener(handler);
		miExit.addActionListener(handler);
		setSize(300, 200);
		setVisible(true);
	}

	// ���õ� ������ ������ �о TextArea�� �����ִ� �޼���
	void fileOpen(String fileName) {
		FileReader fr = null;
		BufferedReader br = null;
		StringWriter sw = null;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			sw = new StringWriter();
			String line = "";
			
			// 1. BuffredReader�� FileReader�� �̿��ؼ� ������ ������
			// ���δ����� �д´�.
			while ((line = br.readLine()) != null) {
				
				// 2. StringWriter�� ����Ѵ�.
				sw.write(line);
				sw.write('\n'); // ���๮�ڸ� ����Ѵ�.
			}
			
			// 3. StringWriter�� ������ content(TextArea)�� �����ش�.
			content.setText(sw.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
			}
		}
	} // fileOpen�޼����� ��
		// TextArea�� ������ ������ ���Ͽ� �����ϴ� �޼���

	void saveAs(String fileName) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			
			// 1. BuffredWriter�� FileWriter�� �����Ѵ�.
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			
			// 2. content�� �ִ� ������ �����ͼ� BufferedWriter�� ����Ѵ�.
			bw.write(content.getText()); // TextArea�� ������ ���Ͽ� �����Ѵ�.
			
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				// 3. BufferedWriter�� �ݴ´�.
				if (bw != null)
					bw.close();
			} catch (IOException e) {
			}
		} // try
	} // saveAs�޼����� ��

	public static void main(String args[]) {
		Exercise14_9 mainWin = new Exercise14_9("Text Editor");
	} // main�޼����� ��
		// �޴��� Ŭ������ �� �޴��� ó���ڵ�

	class MyHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("New")) {
				content.setText("");
			} else if (command.equals("Open")) {
				FileDialog fileOpen = new FileDialog(Exercise14_9.this, "���Ͽ���");
				fileOpen.setVisible(true);
				fileName = fileOpen.getDirectory() + fileOpen.getFile();
				System.out.println(fileName);
				// ���õ� ������ ������ TextArea�� �����ش�.
				fileOpen(fileName);
			} else if (command.equals("Save As...")) {
				FileDialog fileSave = new FileDialog(Exercise14_9.this, "��������",
						FileDialog.SAVE);
				fileSave.setVisible(true);
				fileName = fileSave.getDirectory() + fileSave.getFile();
				System.out.println(fileName);
				// ���� TextArea�� ������ ���õ� ���Ͽ� �����Ѵ�.
				saveAs(fileName);
			} else if (command.equals("Exit")) {
				System.exit(0); // ���α׷��� �����Ų��.
			}
		}
	} // class MyHandler
} // Exercise14_9Ŭ������ ��