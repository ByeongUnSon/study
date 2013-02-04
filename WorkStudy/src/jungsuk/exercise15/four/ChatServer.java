package jungsuk.exercise15.four;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class ChatServer extends Frame {
	String nickname = "";
	DataOutputStream out;
	DataInputStream in;
	Panel p = new Panel();
	TextArea ta = new TextArea();
	TextField tf = new TextField();

	ChatServer(String nickname) {
		super("Chatting");
		this.nickname = nickname;
		p.setLayout(new BorderLayout());
		p.add(tf, "Center");
		add(ta, "Center");
		add(p, "South");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		EventHandler handler = new EventHandler();
		ta.addFocusListener(handler);
		tf.addFocusListener(handler);
		tf.addActionListener(handler);
		ta.setEditable(false);
		setBounds(200, 200, 300, 200);
		setVisible(true);
		tf.requestFocus();
	}

	void startServer() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			/*
			 * (1) �Ʒ��� ������ �°� �ڵ带 �ۼ��Ͻÿ�. 1. ��������� �����Ͽ� 7777�� ��Ʈ�� ���ս�Ų��. 2. ta��
			 * "������ �غ�Ǿ����ϴ�."��� �����ش�. 3. ������ ������ ��ٸ���. 4. ta�� "����� ����Ǿ����ϴ�."���
			 * �����ش�. 5. ����� ���� ������ �Է½�Ʈ���� ��½�Ʈ���� ���´�. 6. �ݺ����� �̿��ؼ� �Է½�Ʈ����
			 * null�� �ƴ� ���� �Է½�Ʈ�����κ��� �����͸� �о ta�� append�Ѵ�.
			 */
			serverSocket = new ServerSocket(7777);
			ta.setText("������ �غ�Ǿ����ϴ�.");
			socket = serverSocket.accept();
			ta.append("\r\n" + "����� ����Ǿ����ϴ�.");
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			while (in != null) {
				String msg = in.readUTF();
				ta.append("\r\n" + msg);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE : java ChatServer NICKNAME");
			System.exit(0);
		}
		ChatServer chatWin = new ChatServer(args[0]);
		chatWin.startServer();
	} // main

	class EventHandler extends FocusAdapter implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String msg = tf.getText();
			if ("".equals(msg))
				return;
			/*
			 * (2) �˸��� �ڵ带 �־� �ϼ��Ͻÿ�.
			 */
			if (out != null) {
				try {
					out.writeUTF(nickname + ">" + msg); 
				} catch (IOException e) { }
			}
			
			ta.append("\r\n" + nickname + ">" + msg);
			tf.setText("");
		}

		public void focusGained(FocusEvent e) {
			tf.requestFocus();
		}
	} // class EventHandler
} // class