package util;

/**
 *<pre>
 *  ���ڿ� ���ۿ� ���� �߰� ����� ���� �Ѵ�.
 * </pre> 
 * @author ����ȣ
 * @version 1.0, 01/01/03 
 */

public class StringUtil {

	/**
	 *
	 * <pre>
	 *  ���� ���ڿ����� �պκ��� �����ϰ� partSize ũ���� ĳ���͸��� �����Ѵ�. 
	 *  �α׸� ���� ȭ�� �ֿܼ� ǥ���ϴ� ��� 80 �÷��� ���� ���� �ʵ��� �Ҷ� ����Ѵ�.   	   
	 * </pre>
	 * @param        String  ���� ���ڿ�
	 * @param        �κ� ���ڿ� ������    
	 * @return 	     String  partSize �÷� ������ ���ڿ� 
	 */

	public static String getPartString(String orgStr, int partSize) {
		if (orgStr == null || orgStr.trim().equals(""))
			return orgStr;
		int size = orgStr.length();
		if (size >= partSize)
			return "..." + orgStr.substring((size - partSize) + 3);
		else
			return orgStr;
	}

	/**
	 *
	 * <pre>
	 *  ��� ���ڿ����� ��ġ �ϴ� �Ϻ� ���ڿ��� ���ϴ� �ٸ� ���ڿ��� ġȯ�Ѵ�. 	   
	 * </pre>
	 *  
	 * @param        String  strTarget ���� ����� �Ǵ� ���� ���ڿ� 
	 * @param        String  strSearch ���� ����� ��� �ִ� ġȯ��� ���ڿ�
	 * @param        String  strReplace ġȯ�� ���ڿ� 
	 * @return 	     String  ġȯ�۾��� ���� ���ڿ�     
	 * @exception    Exception
	 */
	public static String replace(
		String strTarget,
		String strSearch,
		String strReplace)
		throws Exception {
		String result = null;

		int SEARCH_STR_LENG = strSearch.length();
		if (SEARCH_STR_LENG < 1)
			return strTarget;

		String strCheck = new String(strTarget);
		StringBuffer strBuf = new StringBuffer();

		while (true) {
			int begin = strCheck.indexOf(strSearch);
			if (begin == -1) {
				strBuf.append(strCheck);
				break;
			} else {
				int end = begin + SEARCH_STR_LENG;
				strBuf.append(strCheck.substring(0, begin));
				strBuf.append(strReplace);
				strCheck = strCheck.substring(end);
			}
		}

		result = strBuf.toString();

		return result;
	}
}
