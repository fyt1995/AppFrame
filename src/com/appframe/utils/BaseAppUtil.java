package com.appframe.utils;

import java.net.URI;
import java.util.ArrayList;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;

/**
 * App
 * @author Arvin
 *
 */
public class BaseAppUtil {
	/**
	 * 获取手机型号
	 * @return
	 */
	public static String getModelForOS(){
		return android.os.Build.MODEL;
	}

	/**
	 * 获取android版本
	 * @return
	 */
	public static int getVersionSDKForOS(){
		return android.os.Build.VERSION.SDK_INT;
	}
	
	/**
	 * 获取android版本名称
	 * @return
	 */
	public static String getVersionReleaseForOS(){
		return android.os.Build.VERSION.RELEASE;
	}
	
	public static String getSDCardPath(){
		if (existSDCard())
			return Environment.getExternalStorageDirectory().toString();
		else 
			return null;
	}
	
	public static URI getSDCardUri(){
		if (existSDCard())
			return Environment.getExternalStorageDirectory().toURI();
		else
			return null;
	}
	
	public static boolean existSDCard(){
		return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
	}
	
	/**
	 * Get the App version code
	 * @param context
	 * @return
	 */
	public static int getVerCode(Context mContext) {
		String mPackageName = mContext.getPackageName();
		
        int verCode = -1;  
        try {  
            verCode = mContext.getPackageManager().getPackageInfo(mPackageName, 0).versionCode;  
        } catch (NameNotFoundException e) {  
            e.printStackTrace();  
        }  
        return verCode;  
    }  
	
	/**
	 * Get the App version name
	 * @param context
	 * @return
	 */
    public static String getVerName(Context mContext){
    	String mPackageName = mContext.getPackageName();
    	
        String verName = "";  
        try {  
            verName = mContext.getPackageManager().getPackageInfo(mPackageName, 0).versionName;  
        } catch (NameNotFoundException e) {  
            e.printStackTrace(); 
        }  
        return verName;     
    }
    
    /**
	 * 判断服务是否在运行
	 * @param context
	 * @param serviceName
	 * @return
	 */
	public static boolean isServiceWorked(Context context, String serviceName) {
		ActivityManager myManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		ArrayList<RunningServiceInfo> runningService = (ArrayList<RunningServiceInfo>) myManager.getRunningServices(Integer.MAX_VALUE);
		for (int i = 0; i < runningService.size(); i++) {
			if (runningService.get(i).service.getClassName().toString().equals(serviceName)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断是否debug状态
	 * @param context
	 * @return
	 */
	public static boolean isApkDebugable(Context context) {  
        try {  
            ApplicationInfo info= context.getApplicationInfo();  
                return (info.flags&ApplicationInfo.FLAG_DEBUGGABLE)!=0;  
        } catch (Exception e) {  
              
        }  
        return false;  
    }
	

	/**
     * 判断网络是否可用
     * @param context
     * @return
     */
	public static boolean isNetworkConnected(Context mContext) { 
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager mConnectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        
        if (mConnectivityManager == null) {
            return false;
        }
        else {
            // 获取NetworkInfo对象
            NetworkInfo[] networkInfo = mConnectivityManager.getAllNetworkInfo();
            
            if (networkInfo != null && networkInfo.length > 0) {
                for (int i = 0; i < networkInfo.length; i++) {
                    // 判断当前网络状态是否为连接状态
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false; 
	}
	
	/**
	 * 判断是否有网络连接
	 * @param context
	 * @return
	 */
	public static boolean isNewConnected(Context context){
		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);  
        if (connectivityManager!=null) {  
        	NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();
        	for (int i = 0; i < networkInfos.length; i++) {
        		NetworkInfo.State state = networkInfos[i].getState();
        		if (NetworkInfo.State.CONNECTED == state) {
        			return true;  
        		}  
        	}  
        }
        
        return false;
	}
	
	/**
	 * 判断wifi是否可用
	 * @param context
	 * @return
	 */
	public static boolean isWifiConnected(Context context) { 
		if (context != null) { 
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context 
			.getSystemService(Context.CONNECTIVITY_SERVICE); 
			NetworkInfo mWiFiNetworkInfo = mConnectivityManager 
			.getNetworkInfo(ConnectivityManager.TYPE_WIFI); 
			if (mWiFiNetworkInfo != null) { 
				return mWiFiNetworkInfo.isAvailable(); 
			} 
		} 
		return false; 
	}
	
	/**
	 * 判断MOBILE网络是否可用
	 * @param context
	 * @return
	 */
	public static boolean isMobileConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
			.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mMobileNetworkInfo = mConnectivityManager
			.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
			if (mMobileNetworkInfo != null) {
				return mMobileNetworkInfo.isAvailable();
			}
		}
		return false;
	}
	
	/**
	 * 获取当前网络连接的类型信息
	 * @param context
	 * @return
	 */
	public static int getConnectedType(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
			.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
			if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
				return mNetworkInfo.getType();
			}
		}
		return -1;
	}
}
