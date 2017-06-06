package com.appframe.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/**
 * String tool
 * @author Arvin
 *
 */
public class StringUtil {
	
	final static int BUFFER_SIZE = 4096;  
    
    /**  
     * 将InputStream转换成String  
     * @param in InputStream  
     * @return String  
     * @throws Exception  
     *   
     */  
    public static String InputStreamToString(InputStream in){  
        String result = null;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
         
        int count = -1;  
        try {
        	byte[] data = new byte[BUFFER_SIZE]; 
        	
			while((count = in.read(data,0,BUFFER_SIZE)) != -1){
			    outStream.write(data, 0, count);
			}
			
			result = new String(outStream.toByteArray(),"utf-8"); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
 
        return result;
    }  
      
    /**  
     * 将InputStream转换成某种字符编码的String  
     * @param in  
     * @param encoding  
     * @return  
     * @throws Exception  
     */  
	public static String InputStreamToString(InputStream in,String encoding) throws Exception{  
          
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[] data = new byte[BUFFER_SIZE];  
        int count = -1;  
        while((count = in.read(data,0,BUFFER_SIZE)) != -1)  
            outStream.write(data, 0, count);  
          
        data = null;  
        return new String(outStream.toByteArray(),"ISO-8859-1");  
    }  
      
    /**  
     * 将String转换成InputStream  
     * @param in  
     * @return  
     * @throws Exception  
     */  
    public static InputStream StringToInputStream(String in) throws Exception{  
        ByteArrayInputStream is = new ByteArrayInputStream(in.getBytes("UTF-8"));  
        return is;  
    }  
      
    /**  
     * 将InputStream转换成byte数组  
     * @param in InputStream  
     * @return byte[]  
     * @throws IOException  
     */  
    public static byte[] InputStreamToByte(InputStream in) throws IOException{  
          
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[] data = new byte[BUFFER_SIZE];  
        int count = -1;  
        while((count = in.read(data,0,BUFFER_SIZE)) != -1)  
            outStream.write(data, 0, count);  
          
        data = null;  
        return outStream.toByteArray();  
    }  
      
    /**  
     * 将byte数组转换成InputStream  
     * @param in  
     * @return  
     * @throws Exception  
     */  
    public static InputStream byteToInputStream(byte[] in) throws Exception{  
          
        ByteArrayInputStream is = new ByteArrayInputStream(in);  
        return is;  
    }  
      
    /**  
     * 将byte数组转换成String  
     * @param in  
     * @return  
     * @throws Exception  
     */  
    public static String byteToString(byte[] in) throws Exception{  
          
        InputStream is = byteToInputStream(in);  
        return InputStreamToString(is);  
    }  
	
	/**
	 * Access to capital letters
	 * @param arg0
	 * @return
	 */
	public static String getUpperCase(String arg0){
		return arg0.toUpperCase(Locale.getDefault());
	}
	
	/**
	 * Access to lowercase letters
	 * @param arg0
	 * @return
	 */
	public static String getLowerCase(String arg0){
		return arg0.toLowerCase(Locale.getDefault());
	}
	
	
}
