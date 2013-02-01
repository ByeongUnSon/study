package util;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *<pre>
 *  로그를 파일에 기록하는 기능을 제공 한다.
 * </pre> 
 * @author 차종호
 * @version 1.0, 01/01/03 
 */

public class LogUtil {

	/**
	 *
	 * <pre>
	 *  현재 시각을 반환한다.	   
	 * </pre>
	 *  
	 * @param        None
	 * @return 	     String   - "yyyy.MM.dd_hh.mm.ss" 형태의 현재 시각   
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
	 *  로그파일의 뒷부분에 내용을 추가(APPEND) 한다. 
	 *  존재 하지 않을 경우 폴더 트리 구조만을 생성한다.  
	 * </pre>
	 *  
	 * @param        String 로그 파일명
	 * @param        String 로그 내용  
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
