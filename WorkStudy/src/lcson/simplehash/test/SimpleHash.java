package lcson.simplehash.test;

public class SimpleHash {

	private int hTableSize;
	private Entry[] hTable;
	
	public SimpleHash(int hTableSize) {
		this.hTableSize = hTableSize;
		hTable = new Entry[hTableSize];		// �ؽ� ���̺� �޸� �Ҵ�
	}
	
	public int hFunc(int value) {
		return value % hTableSize;
	}
	
	public void insert(int data) {
		int value;
		Entry entry;	
		
		entry = new Entry();
		entry.setValue(data);
		
		value = hFunc(data);	// �ؽð� ���
		if (hTable[value] == null) {	// �ؽð��� ���� ������� ���
			hTable[value] = entry;	// ����
			System.out.print(data + " �Է�\t");
		} else {
			System.out.print(data + " �Է� ����\t");
		}
	}
	
	public void showHashTable() {
		for (int i=0; i<hTableSize; i++) {
			if (hTable[i] == null)
				System.out.print("_ ");
			else
				System.out.print(hTable[i].getValue() + " ");
		}
		System.out.println();

	}
	
	public static void main(String[] args) {
		System.out.println("This is Simple Hash");
		
		SimpleHash sh = new SimpleHash(11);
		
		sh.insert(4);
		sh.showHashTable();
		sh.insert(8);
		sh.showHashTable();
		sh.insert(12);
		sh.showHashTable();
		sh.insert(16);
		sh.showHashTable();
		sh.insert(20);
		sh.showHashTable();
		sh.insert(24);
		sh.showHashTable();
		sh.insert(28);
		sh.showHashTable();
		sh.insert(32);
		sh.showHashTable();
		
		sh.insert(30);
	}

}
