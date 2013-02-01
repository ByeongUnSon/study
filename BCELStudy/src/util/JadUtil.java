package util;


import java.io.File;
import java.io.InputStreamReader;
/**
 *<pre>
 *  �ڹ� �������Ϸ��� JAD �� �̿��Ͽ� FOLDER ������ ��� Ŭ���� ������ �ҽ��� ��ȯ�Ѵ�.
 * </pre> 
 * @author ����ȣ
 * @version 1.0, 01/01/03 
 */

public class JadUtil {
	private static String CLASS_PATH = "";
	private static String JAVA_PATH = "";
	private static String LOG_FILE = "";
	int len = -1;
	/**
	*
	* <pre>
	*   JAVA �ҽ��� ������ CLASS ������ ���� �Ѵ�.    
	* </pre>
	*  
	* @param        classesPath  CLASS ����  	 	 	      
	* @return 	    None 
	* @exception    Exception
	*/
	public void setClassPath(String classesPath) throws Exception {
		File classesFile = new File(classesPath);
		CLASS_PATH = classesFile.getAbsolutePath();
	}

	/**
	*
	* <pre>
	*  ����� JAVA �ҽ��� ������ ������ ���� �Ѵ�.    
	* </pre>
	*  
	* @param        classesPath  JAVA �ҽ� ����  	 	 	      
	* @return 	    None 
	* @exception    Exception
	*/
	public void setJavaPath(String javaPath) throws Exception {
		File javaPathFile = new File(javaPath);
		JAVA_PATH = javaPathFile.getAbsolutePath();
	}

	/**
	*
	* <pre>
	*   ���� ���� �α� ������ ���� �Ѵ�.    
	* </pre>
	*  
	* @param        logFileName  ���� ���� �α� ���� 	 	 	      
	* @return 	    None 
	* @exception    Exception
	*/
	//public void setLogFile(String logFileName) throws Exception {
//
	//	LOG_FILE = logFileName + "_" + LogUtil.getCurrentTimeStamp() + ".csv";
	//}

	private void folderCheck() {

		File classPath = new File(CLASS_PATH);
		if (!classPath.exists()) {
			System.out.println(
				" JAD_SRC_PATH [" + CLASS_PATH + "] does not exist ... ");
			System.exit(1);
		}

		File javaPath = new File(JAVA_PATH);
		if (!javaPath.exists()) {
			javaPath.mkdirs();
		}

	}

	private String getTargetFileName(
		File srcFile,
		String srcPath,
		String tgtPath)
		throws Exception {

		String srcFilePath = srcFile.getAbsolutePath();
		String tgtFileName = StringUtil.replace(srcFilePath, srcPath, tgtPath);
		return tgtFileName;
	}

//	private void logWrite(File jadFile) throws Exception {
	//	String fileName = getTargetFileName(jadFile, CLASS_PATH, "");
		//LogUtil.log(LOG_FILE, fileName + "," + jadFile.length());
	//}

	private void callProcess(String processStr) {
		Process p = null;
		StringBuffer result = new StringBuffer();

		final int BUFFER_SIZE = 1024;
		
		try {
			p = Runtime.getRuntime().exec(processStr);

			InputStreamReader err =
				new InputStreamReader(p.getErrorStream(), "KSC5601");
			char[] buff = new char[BUFFER_SIZE];
			
			while ((len = err.read(buff, 0, BUFFER_SIZE)) > -1) {
				result.append(buff);
				buff = new char[BUFFER_SIZE];
			}

			if (p.waitFor() != 0) {
				System.out.println("Error executing command: " + processStr);
				System.exit(-1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			p.destroy();
		}

	}
	private void processFile(File jadFile) throws Exception {
		FileUtil.clearCurrentLine();
		System.out.print(
			"\r PROCESSING["
				+ StringUtil.replace(jadFile.getAbsolutePath(), CLASS_PATH, "")
				+ "]");
		String cmdStr =
			"jad  -s  java -r  -d \""
				+ JAVA_PATH.trim()
				+ "\" -o \""
				+ jadFile.getAbsolutePath().trim()
				+ "\"";
		callProcess(cmdStr);

		//logWrite(jadFile);

	}

	private void processFolder(File newFile) throws Exception {
		File[] fileList = newFile.listFiles();

		for (int i = 0, size = fileList.length; i < size; i++) {
			if (fileList[i].isDirectory()) {
				processFolder(fileList[i]);
			} else {
				processFile(fileList[i]);
			}
		}

	}

	/**
	*
	* <pre>
	*  ���� ������ �߰� ���� ���� ������ �� �Ͽ�  �߰�/����� �κи� �����س���. 
	* </pre>
	*  
	* @param        None
	* @return 	    None     
	* @exception    Exception
	*/
	public void process() throws Exception {
		folderCheck();

		File javaPath = new File(CLASS_PATH);
		System.out.println(
			" GENERATING JAVA SOURCES FOLDER .... [" + JAVA_PATH + "]");
		long start = System.currentTimeMillis();
		processFolder(javaPath);
		long end = System.currentTimeMillis();
		FileUtil.clearCurrentLine();
		System.out.println(
			"\r PROCESSING[DONE...] ELAPSED " + (end - start) + " ms ");
	}

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println(
				" Usage   : jad JadUtil <CLASS_PATH> <JAVA_PATH> <LOG_FILE> "
					+ args.length);
			System.out.println(
				" Example : jad JadUtil d:/test/classes d:/test/java_src  d:/test/jadutil_log ");
		} else {

			try {

				JadUtil selfTest = new JadUtil();
				String CLASS_PATH = args[0];
				String JAVA_PATH = args[1];
				String LOG_FILE = args[2];

				selfTest.setClassPath(CLASS_PATH);
				selfTest.setJavaPath(JAVA_PATH);
				//selfTest.setLogFile(LOG_FILE);

				selfTest.process();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
