package lcson.tree.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeApp {

	public static void main(String[] args) throws IOException {
		int value;
		BinaryTree tree = new BinaryTree();
		
		tree.insert(50);
		tree.insert(27);
		tree.insert(68);
		tree.insert(12);
		tree.insert(36);
		tree.insert(55);
		tree.insert(82);
		tree.insert(7);
		tree.insert(19);
		tree.insert(49);
		tree.insert(76);
		
		while (true) {
			System.out.println("---------------------------------------");
			System.out.println("1. Traverse");
			System.out.println("2. Find");
			System.out.println("3. Find Min & Max");
			System.out.println("4. Insert");
			System.out.println("5. Delete");
			System.out.println("6. Display Tree");
			System.out.print("Enter the number of command: ");
			int command = getInt();
			
			System.out.println();
			
			switch (command) {
				case 1:
					System.out.println("1. Preorder");
					System.out.println("2. Inorder");
					System.out.println("3. Postorder");
					System.out.print("Enter the number of type: ");
					value = getInt();
					tree.traverse(value);
					System.out.println();
					break;
				case 2:
					System.out.print("Enter value: ");
					value = getInt();
					Node found = tree.find(value);
					
					if (found != null) {
						System.out.print("Found: ");
						found.showNode();
						System.out.println();
					} else 
						System.out.print("Could not find " + value + '\n');
					System.out.println();
					break;
				case 3:
					System.out.println("1. Find Mininum value");
					System.out.println("2. Find Maximum value");
					System.out.print("Enter number of type: ");
					value = getInt();
					if (value == 1) {
						found = tree.findMin();
						System.out.print("Found: ");
						found.showNode();
						System.out.println();
					} else if (value == 2) {
						found = tree.findMax();
						System.out.print("Found: ");
						found.showNode();
						System.out.println();
					}
					System.out.println();
					break;
				case 4:
					System.out.print("Enter integer value to insert: ");
					value = getInt();
					tree.insert(value);
					System.out.println();
					System.out.println("Insert Result");
					tree.display();
					System.out.println();
					break;
				case 5:
					System.out.print("Enter integer value to delete: ");
					value = getInt();
					boolean complete = tree.delete(value);
					if (complete) {
						System.out.print("Deleted " + value + '\n');
						System.out.println("Delete Result");
						tree.display();
					} else 
						System.out.print("Could not delete " + value + '\n');
					System.out.println();
					break;
				case 6:
					tree.display();
					break;
				default:
					System.out.println("Invalid entry");
			}
		}
	}
	
	static int getInt() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return Integer.parseInt(s);
	}

}
