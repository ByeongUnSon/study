import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Vector;


/**
 * * ���� ���� �Է½�Ʈ���� ���������� �����ؼ� �ϳ��� ��Ʈ�����κ��� �����͸� �д� �Ͱ� ���� ó���� �� �ֵ��� �����ش�. 
* 	SequenceInputStream�� �����ڸ� �����ϰ� ������ �۾��� �ٸ� �Է½�Ʈ���� �ٸ��� �ʴ�.
* 	ū ������ ���� ���� ���� ���Ϸ� �������ٰ� �ϳ��� ���Ϸ� ��ġ�� �Ͱ� ���� �۾��� ������ �� ����ϸ� ���� ���̴�.
* 	ByteArrayInputStream�� Vector�� SequenceInputStream�� �̿��ؼ� �ϳ��� �Է½�Ʈ��ó�� �ٷ� �� �ִ�.
 *
 */
public class SequenceInputStreamEx {
 /**
  * @param args
  */
 public static void main(String[] args) {
  byte[] arr1 = {0, 1, 2};
  byte[] arr2 = {3, 4, 5};
  byte[] arr3 = {6, 7, 8};
  byte[] outSrc = null;
  
  Vector v = new Vector();
  v.add(new ByteArrayInputStream(arr1));
  v.add(new ByteArrayInputStream(arr2));
  v.add(new ByteArrayInputStream(arr3));
  
  SequenceInputStream input = new SequenceInputStream(v.elements());
  ByteArrayOutputStream output = new ByteArrayOutputStream();
  
  for (int i=0; i<v.size(); i++) {
	  System.out.println(v.get(i));
  }
  int data = 0;
  
  try {
   while((data = input.read()) !=-1) {
    output.write(data);
   }
  } catch(IOException e) {}
  
  outSrc = output.toByteArray();
  System.out.println("Input Source1 :" + Arrays.toString(arr1));
  System.out.println("Input Source2 :" + Arrays.toString(arr2));
  System.out.println("Input Source3 :" + Arrays.toString(arr3));
  System.out.println("Output Source :" + Arrays.toString(outSrc));
  
 }
} 
