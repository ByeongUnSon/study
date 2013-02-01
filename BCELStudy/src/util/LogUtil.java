package util;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *<pre>
 *  �α׸� ���Ͽ� ����ϴ� ����� ���� �Ѵ�.
 * </pre> 
 * @author ����ȣ
 * @version 1.0, 01/01/03 
 */

public class LogUtil {

	/**
	 *
	 * <pre>
	 *  ���� �ð��� ��ȯ�Ѵ�.	   
	 * </pre>
	 *  
	 * @param        None
	 * @return 	     String   - "yyyy.MM.dd_hh.mm.ss" ������ ���� �ð�   
	 * @exception    Exception
	 */

	public static String getCurrentTimeStamp() throws Exception {

		Calendar cal = new GregorianCalendar();
		Timestamp result = new Timestamp(cal.getTime().getTime());
		SimpleDateFormat formatter =
			new SimpleDateFormat("yyyy.MM.dd_hh.mm.ss");
		return formatter.format(result);
	}

	/**
	 *
	 * <pre>
	 *  �α������� �޺κп� ������ �߰�(APPEND) �Ѵ�. 
	 *  ���� ���� ���� ��� ���� Ʈ�� �������� �����Ѵ�.  
	 * </pre>
	 *  
	 * @param        String �α� ���ϸ�
	 * @param        String �α� ����  
	 * @return 	     None     
	 * @exception    Exception
	 */

	public static void log(String logFileName, String msg) {

		FileOutputStream fout = null;
		PrintStream dout = null;

		try {

			fout = new FileOutputStream(logFileName, true);
			dout = new PrintStream(fout);
			dout.println(msg);
			dout.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dout != null)
					dout.close();
				if (fout != null)
					fout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
