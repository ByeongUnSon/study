package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *<pre>
 *  파일및 폴더에 관련된 유용한 기능을 제공 한다.
 * </pre> 
 * @author 차종호
 * @version 1.0, 01/01/03 
 */

public class FileUtil {

	/**
	*
	* <pre>
	*   같은 라인의 화면에 내용을 표시 하기 위해 Carrage Return 을 한다.   
	* </pre>
	*  
	* @param        None    	 	 	      
	* @return 	    None 
	* @exception    Exception
	*/
	public static void clearCurrentLine() {
		System.out.print("\r");
		for (int j = 0; j < 79; j++)
			System.out.print(" ");
	}

	/**
	 *
	 * <pre>
	 *  대상 폴더의 모든 파일을 삭제한다. 
	 * </pre>
	 *  
	 * @param      File 대상폴더
	 * @return 	   None     
	 * @exception  Exception
	 */
	public static void deleteEachFiles(File deleted) throws Exception {

		File[] fileList = deleted.listFiles();

		for (int i = 0, size = fileList.length; i < size; i++) {

			if (fileList[i].isDirectory()) {
				deleteEachFiles(fileList[i]);
				fileList[i].delete();

			} else {
				fileList[i].delete();
			}
			clearCurrentLine();
			System.out.print(
				"\r DELETING["
					+ StringUtil.getPartString(fileList[i].getAbsolutePath(), 50)
					+ "]");

		}
	}

	/**
	 *
	 * <pre>
	 *  원본 파일과 대상 파일이 동일한지 검사 한다. 
	 *  바이트 단위의 정확한 비교가 가능하다.  
	 * </pre>
	 *  
	 * @param      File newFile 원본파일
	 * @param      File oldFile 대상파일
	 * @return 	   None     
	 * @exception  Exception
	 */
	public static boolean isIdentical(File newFile, File oldFile)
		throws Exception {

		InputStream isNew = null;
		InputStream isOld = null;

		try {

			isNew = new BufferedInputStream(new FileInputStream(newFile));
			isOld = new BufferedInputStream(new FileInputStream(oldFile));

			int newOneChar = 0;
			int oldOneChar = 0;

			while ((newOneChar = isNew.read()) != -1) {
				oldOneChar = isOld.read();
				if (newOneChar == oldOneChar)
					continue;
				else
					return false;

			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (isNew != null)
					isNew.close();
				if (isOld != null)
					isOld.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}

	}

	/**
	*
	* <pre>
	*  대상 파일을 카피한다. 
	* </pre>
	*  
	* @param        File - 원본파일 	 	 	      
	* @param        String - 대상 파일 명 ( 원본파일명과 다르게 지정 가능 )     
	* @return 	    None     
	* @exception    Exception
	*/

	public static void copyFile(File srcFile, String destFileName)
		throws Exception {

		InputStream srcfileStream = null;
		OutputStream dstfileStream = null;
		File dstfile = null;

		try {

			srcfileStream =
				new BufferedInputStream(new FileInputStream(srcFile));

			dstfile = new File(destFileName);

			if (!dstfile.exists())
				new File(dstfile.getParent()).mkdirs();

			dstfileStream =
				new BufferedOutputStream(new FileOutputStream(dstfile));

			byte[] buf = new byte[1024];

			int len;
			while (((len = srcfileStream.read(buf)) > 0)) {
				dstfileStream.write(buf, 0, len);
			}

		} finally {
			if (srcfileStream != null)
				srcfileStream.close();
			if (dstfileStream != null)
				dstfileStream.close();
		}
	}

	/**
	 *
	 * <pre>
	 *  대상 폴더가 존재 할경우 폴더 트리 내의 모든 파일을 삭제한다.
	 *  존재 하지 않을 경우 폴더 트리 구조만을 생성한다.  
	 * </pre>
	 *  
	 * @param        대상폴더
	 * @return 	     None     
	 * @exception    Exception
	 */

	public static String clearFolder(String destFolderName) throws Exception {
		File deleteFolderRoot = new File(destFolderName);
		String resultPath = deleteFolderRoot.getAbsolutePath();

		System.out.println(
			" CLEARING RESULT FOLDER .... ["
				+ StringUtil.getPartString(resultPath, 30)
				+ "]");

		long start = System.currentTimeMillis();

		if (!deleteFolderRoot.exists())
			deleteFolderRoot.mkdirs();
		else
			FileUtil.deleteEachFiles(deleteFolderRoot);

		deleteFolderRoot.mkdirs();

		long end = System.currentTimeMillis();

		FileUtil.clearCurrentLine();
		System.out.println(
			"\r DELETING[DONE...] ELAPSED " + (end - start) + " ms ");
		return resultPath;
	}

}
