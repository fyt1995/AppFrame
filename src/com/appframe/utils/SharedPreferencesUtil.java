package com.appframe.utils;

import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/** 
 * @author  Arvin: 
 * @version 2016年5月27日 下午1:07:42 
 * 
 */
public class SharedPreferencesUtil {
	
	/**************************SharedPreferences数据保存***************************/
	/**
	 * 基于SharePreferences保存Map数据
	 * @param mContext
	 * @param arg0
	 * @param maps
	 */
	public static void saveSharePreferences(Context mContext, String arg0, Map<String, Object> maps) {
		SharedPreferences share = mContext.getSharedPreferences(arg0, 0);
		Editor mEditor = share.edit();
	        
        for (String key : maps.keySet()) {  
        	Object value = maps.get(key);  
        	
        	saveEditor(mEditor, key, value);
        }
        
        mEditor.commit();
        share = null;
    }
	
	/**
	 * 基于SharePreferences保存单个标签数据
	 * @param mContext
	 * @param arg0
	 * @param key
	 * @param val
	 */
	public static void saveSharePreference(Context mContext, String arg0, String key, Object obj) {
		SharedPreferences share = mContext.getSharedPreferences(arg0, 0);
		Editor mEditor = share.edit();
		saveEditor(mEditor, key, obj);
        
        mEditor.commit();
        share = null;
    }
	
	/**
	 * 基于SharePreferences保存数据,根据类型保存
	 * @param mEditor
	 * @param key
	 * @param obj
	 */
	public static void saveEditor(Editor mEditor, String key, Object obj) {
		if (obj instanceof String){
    		mEditor.putString(key, obj.toString());
    	} else if (obj instanceof Integer){
    		mEditor.putInt(key, ((Integer) obj).intValue());
    	} else if (obj instanceof Boolean){
    		mEditor.putBoolean(key, ((Boolean) obj).booleanValue());
    	} else if (obj instanceof Boolean){
    		mEditor.putLong(key, Long.parseLong((String) obj));
    	}
	}
	
	
	/**************************SharedPreferences数据读取***************************/
	/**
	 * 基于SharePreferences，根据key获取对应的值
	 * @param mContext
	 * @param arg0
	 * @param key
	 * @return
	 */
	public static String getSharePreferencesByKey(Context mContext, String arg0, String key){
		SharedPreferences share = mContext.getSharedPreferences(arg0, 0);
		String val = share.getString(key, "");
		
		return val;
	}
	
	/**
	 * 基于SharePreferences，根据key获取对应的值
	 * @param mContext
	 * @param arg0
	 * @param key
	 * @return
	 */
	public static boolean getSharePreferencesByKeyForBoolean(Context mContext, String arg0, String key){
		SharedPreferences share = mContext.getSharedPreferences(arg0, 0);
		boolean val = share.getBoolean(key, false);
		
		return val;
	}
	
	public static int getSharePreferencesByKeyForInt(Context mContext, String arg0, String key){
		SharedPreferences share = mContext.getSharedPreferences(arg0, 0);
		int val = share.getInt(key, 0);
		
		return val;
	}
}
