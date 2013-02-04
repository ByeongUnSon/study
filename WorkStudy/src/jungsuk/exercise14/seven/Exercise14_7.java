package jungsuk.exercise14.seven;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise14_7 extends Frame {
	
	String nickname = "";
	TextArea ta = new TextArea();
	Panel p = new Panel();
	TextField tf = new TextField(30);
	Button bSave = new Button("저장");
	
	public Exercise14_7(String nickname) {
		super("Chatting");
		this.nickname = nickname;
		
		setBounds(200, 100, 300, 200);
		
		p.setLayout(new FlowLayout());
		p.add(tf, "Center");
		p.add(bSave, "Center");
		
		add(ta, "Center");
		add(p, "South");
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		bSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				FileDialog fileSave = new FileDialog(Exercise14_7.this, "파일저장", FileDialog.SAVE);
				
				fileSave.setVisible(true);
				
				String fileName = fileSave.getDirectory() + fileSave.getFile();
				
				saveAs(fileName);
			}
		});
		
		EventHandler handler = new EventHandler();
		ta.addFocusListener(handler);
		tf.addFocusListener(handler);
		tf.addActionListener(handler);
		
		ta.setText("#" + nickname + "님 즐거운 채팅되세요.");
		ta.setEditable(false);
		
		setResizable(false);
		setVisible(true);
		tf.requestFocus();
	}
	
	void saveAs(String fileName) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			bw.write(ta.getText());	// TextArea의 내용을 파일에 저장한다.
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) { }
		}
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE : java Exercise14_7 NICKNAME");
			System.exit(0);
		}
		
		new Exercise14_7(args[0]);
	}

	class EventHandler extends FocusAdapter implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String msg = tf.getText();
			
			if ("".equals(msg)) return;
			
			ta.append("\r\n" + nickname + ">" + msg);
			tf.setText("");
			
		}
		
		public void focusGained(FocusEvent e) {
			tf.requestFocus();
		}
	}
}



