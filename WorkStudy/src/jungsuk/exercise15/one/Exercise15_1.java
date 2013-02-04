package jungsuk.exercise15.one;

public class Exercise15_1 {

	public static void main(String[] args) {
		byte[] ip = { (byte) 192, (byte) 168, (byte) 10, (byte) 100 };
		byte[] subnet = { (byte) 255, (byte) 255, (byte) 255, (byte) 0 };
		
		byte[] nwAddress = new byte[4];	// ��Ʈ��ũ �ּ�
		byte[] hostAddress = new byte[4];	// ȣ��Ʈ �ּ�
		
		System.out.print("��Ʈ��ũ �ּ�:");
		
		for (int i=0; i<ip.length; i++) {
			nwAddress[i] = (byte) (ip[i] & subnet[i]); // &���� ����
			System.out.print(nwAddress[i] >=0 ? nwAddress[i] : nwAddress[i] + 256);
			System.out.print(".");
		}
		System.out.println();
		System.out.print("ȣ��Ʈ �ּ�:");
		
		for (int i=0; i<ip.length; i++) {
			hostAddress[i] = (byte) (ip[i] & ~subnet[i]);
			System.out.print(hostAddress[i] >=0 ? hostAddress[i] : hostAddress[i] + 256);
			System.out.print(".");
		}
		System.out.println();
	}

}
