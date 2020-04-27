package com.server.chbw.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
 
/**
 * 字符串操作 <功能详细描述>
 * 
 * @author
 * @version
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class StringUtil {
 
	private StringUtil() {
	}
 
	/**
	 * 获取字典字符串中的value <功能详细描述>
	 * 
	 * @param 输入的字典字符串
	 * @return [参数说明]字符串中的值
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static final String dictToValue(String mString) {
		if (mString != null && mString.length() >= 1 && mString.contains("#")) {
			String[] strings = mString.split("#");
			return strings[1];
		} else {
			return "";
		}
	}
 
	/**
	 * 获取字典字符串中的ID <功能详细描述>
	 * 
	 * @param 输入的字典字符串
	 * @return [参数说明]字符串中的ID
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static final String dictToID(String mString) {
		if (mString != null && mString.length() >= 1 && mString.contains("#")) {
			String[] strings = mString.split("#");
			return strings[0];
		} else {
			return "";
		}
	}
 
	/**
	 * 是否为null或空字符串
	 * 
	 * @param str
	 * @return [参数说明]
	 * 
	 * @return boolean [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean isEmpty(String str) {
		if (null == str || "".equals(str)) {
			return true;
		}
		return false;
	}
 
	/**
	 * 字符串转为整数(如果转换失败,则返回 -1)
	 * 
	 * @param str
	 * @return [参数说明]
	 * 
	 * @return int [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static int stringToInt(String str) {
		return stringToInt(str, -1);
	}
 
	public static Long stringToLong(String str, Long defaultValue) {
		if (isEmpty(str)) {
			return defaultValue;
		}
		try {
			return Long.parseLong(str.trim());
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}
 
	/** 字符串转日期 **/
	public static Date StrToDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
 
	public static int stringToInt(String str, int DefaultValue) {
		if (isEmpty(str)) {
			return DefaultValue;
		}
		try {
			return Integer.parseInt(str.trim());
		} catch (NumberFormatException e) {
			return DefaultValue;
		}
	}
 
	/** 字符串转化成Float **/
	/*
	 * public static Long stringToLong(String str, long l) { if (isEmpty(str)) {
	 * return l; } String reg="^([-]|[0-9])[0-9]*(\\.\\w*)?$"; Matcher m =
	 * Pattern.compile(reg).matcher(str); if(m.groupCount()>0) return
	 * Long.parseLong(str); return l; }
	 */
 
	/**
	 * 字体串转为boolean (如果转换失败,则返回false)
	 * 
	 * @param str
	 * @return [参数说明]
	 * 
	 * @return boolean [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean stringToBoolean(String str) {
		if (isEmpty(str)) {
			return false;
		}
		try {
			return Boolean.parseBoolean(str.trim());
		} catch (Exception e) {
			return false;
		}
	}
 
	/**
	 * boolean转为字体串
	 * 
	 * @param str
	 * @return [参数说明]
	 * 
	 * @return boolean [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static String BooleanToString(Boolean bool) {
		String booleanString = "false";
		if (bool) {
			booleanString = "true";
		}
		return booleanString;
	}
 
	/**
	 * 生成N位随机数
	 * 
	 * @param num
	 *            长度
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static String get10Random(int num) {
		Random random = new Random();
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < num; i++) {
			res.append(random.nextInt(10));
		}
		return res.toString();
	}
 
	/**
	 * 从异常中获取有用信息
	 * 
	 * @param ex
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static String getExceptionMsg(Throwable ex) {
		Writer writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		ex.printStackTrace(printWriter);
		Throwable cause = ex.getCause();
		while (cause != null) {
			cause.printStackTrace(printWriter);
			cause = cause.getCause();
		}
		printWriter.close();
		String result = writer.toString();
		return result;
	}
 

 
	/**
	 * 通过文件名，获取文件后缀
	 * 
	 * @param fullPath
	 * @return
	 */
	public static String getFileSuffix(String fullPath) {
		String result = "";
		int len = fullPath.length();
		int lastIndex = fullPath.lastIndexOf(".");
		if (len > lastIndex)
			result = fullPath.substring(lastIndex);
		return result;
	}
 
	/**
	 * 通过文件名，获取文件名称
	 * 
	 * @param fullPath
	 * @return
	 */
	public static String getFileName(String fullPath) {
		String result = fullPath;
		int len = fullPath.length();
		int lastIndex = fullPath.lastIndexOf("/");
		if (len > lastIndex)
			result = fullPath.substring(lastIndex + 1);
		return result;
	}
 
	/**
	 * 通过文件名，获取文件名称但没有后缀
	 * 
	 * @param fullPath
	 * @return
	 */
	public static String getFileNameNoFileSuffix(String fullPath) {
		String result = "";
		int len = fullPath.length();
		int lastIndex = fullPath.lastIndexOf("/");
		if (len > lastIndex)
			result = fullPath.substring(lastIndex + 1);
		if (!StringUtil.isEmpty(result)) {//
			len = result.length();
			int index = result.lastIndexOf(".");
			if (len > index) {
				result = result.substring(0, index - 1);
			}
		}
		return result;
	}
 
	/**
	 * 截取时间日期
	 */
	public static String getFilterDate(String data) {
		String fiterdate = "";
		if (data != null && !"".equals(data)) {
			int index = data.indexOf("T");
			fiterdate = data.substring(0, index);
		}
		return fiterdate;
	}
    /**截取字符串 **/
	public static String getFilterNum(String num){
		String fiternum = "";
		if (num != null && !"".equals(num)) {
			int index = num.indexOf(".") + 3;
			fiternum = num.substring(0, index);
		}
		return fiternum;
	}
	
	  /**截取字符串 **/
		public static String getTrueString(String num){
			String fiternum = "";
			if (num != null && !"".equals(num)) {
				
				fiternum = num.substring(1, num.length()-1);
			}
			return fiternum;
		}
		/***
		 * 
		 *获取两位的小数点的字符串
		 */
		public static String getTwoString(String number)
		{
			
			Double num = Double.parseDouble(number);//转换成Double
			DecimalFormat df = new DecimalFormat("0.00");//格式化
			String realNumber = df.format(num);
			return realNumber;
		}
	
	public static void main(String[] args) {
		System.out.println(get10Random(5));
		System.out.println(get10Random(10));
		System.out.println(get10Random(8));
	}
}
