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
 *  ���Ϲ� ������ ���õ� ������ ����� ���� �Ѵ�.
 * </pre> 
 * @author ����ȣ
 * @version 1.0, 01/01/03 
 */

public class FileUtil {

	/**
	*
	* <pre>
	*   ���� ������ ȭ�鿡 ������ ǥ�� �ϱ� ���� Carrage Return �� �Ѵ�.   
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
	 *  ��� ������ ��� ������ �����Ѵ�. 
	 * </pre>
	 *  
	 * @param      File �������
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
	 *  ���� ���ϰ� ��� ������ �������� �˻� �Ѵ�. 
	 *  ����Ʈ ������ ��Ȯ�� �񱳰� �����ϴ�.  
	 * </pre>
	 *  
	 * @param      File newFile ��������
	 * @param      File oldFile �������
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
	*  ��� ������ ī���Ѵ�. 
	* </pre>
	*  
	* @param        File - �������� 	 	 	      
	* @param        String - ��� ���� �� ( �������ϸ�� �ٸ��� ���� ���� )     
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
	 *  ��� ������ ���� �Ұ�� ���� Ʈ�� ���� ��� ������ �����Ѵ�.
	 *  ���� ���� ���� ��� ���� Ʈ�� �������� �����Ѵ�.  
	 * </pre>
	 *  
	 * @param        �������
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
