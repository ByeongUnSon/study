package util;

/**
 *<pre>
 *  문자열 조작에 대한 추가 기능을 제공 한다.
 * </pre> 
 * @author 차종호
 * @version 1.0, 01/01/03 
 */

public class StringUtil {

	/**
	 *
	 * <pre>
	 *  원본 문자열에서 앞부분을 제외하고 partSize 크기의 캐릭터만을 추출한다. 
	 *  로그를 위해 화면 콘솔에 표시하는 경우 80 컬럼에 벗어 나지 않도록 할때 사용한다.   	   
	 * </pre>
	 * @param        String  원본 문자열
	 * @param        부분 문자열 사이즈    
	 * @return 	     String  partSize 컬럼 까지의 문자열 
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
	 *  대상 문자열에서 일치 하는 일부 문자열을 워하는 다른 문자열로 치환한다. 	   
	 * </pre>
	 *  
	 * @param        String  strTarget 변경 대상이 되는 원본 문자열 
	 * @param        String  strSearch 변경 대상이 담고 있는 치환대상 문자열
	 * @param        String  strReplace 치환할 문자열 
	 * @return 	     String  치환작업이 끝난 문자열     
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
