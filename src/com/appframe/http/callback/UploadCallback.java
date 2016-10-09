package com.appframe.http.callback;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import de.greenrobot.dao.query.QueryBuilder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class UploadCallback implements Callback{
	private static final String TAG = "UploadCallback";
	
	private Handler mHandler;
	
	/**
	 * 是否更新数据库
	 */
	private int type;
	
	public UploadCallback(int type) {
		
	}
	
	public UploadCallback(Handler mHandler, int type) {
		this.mHandler = mHandler;
		this.type = type;
	}
	
	@Override
	public void onFailure(Call arg0, IOException arg1) {
		// TODO Auto-generated method stub
		Log.e(TAG, "error ", arg1);
	}

	@Override
	public void onResponse(Call arg0, Response arg1) throws IOException {
		// TODO Auto-generated method stub
		String val = arg1.body().string();
//		Gson mGson = GsonUtil.getGson();
//		JsonObject jsonObj = mGson.fromJson(val, JsonObject.class);
//		Object result = jsonObj.get("result");
//		
//		if (result == null) {
//			return;
//		}
//		String str = jsonObj.get("result").toString();
//
//		HttpJsonResult json = mGson.fromJson(str, HttpJsonResult.class);
//		String sign = json.getSign();
//		String content = json.getContent();
//	        
//		String privateKey = TAppTokenModel.getPrivateKey();
//		String publicKey = TAppTokenModel.getPublicKeyForServer();
//			
//		boolean isTrue = CodeUtil.isVerify(content, sign, publicKey);
//        String value = null;
//        if (isTrue){
//        	value = CodeUtil.decryptForLong(content, privateKey);
//        }
//        if (value == null)
//        	return;
//
//		DownloadBean bean = GsonUtil.getGson().fromJson(value, DownloadBean.class);
//		
//		//更新本地数据库文件上传标志与服务器保存地址
//        if (type == 1 && bean.getUuid() != null) {
//			TAppFjxxbDao dao = BankApplication.getDaoSession().getTAppFjxxbDao();
//			QueryBuilder<TAppFjxxb> fjxxqb = dao.queryBuilder();
//			fjxxqb.where(TAppFjxxbDao.Properties.Uuid.eq(bean.getUuid()));
//			List<TAppFjxxb> fjxxs = fjxxqb.list();
//			if (fjxxs != null && fjxxs.size() > 0) {
//				TAppFjxxb mTAppFjxxb = fjxxs.get(0);
//				mTAppFjxxb.setUrldz(bean.getPath());
//				mTAppFjxxb.setSczt(1);
//				
//				dao.insertOrReplace(mTAppFjxxb);
//			}
//		}
//			
//		if (mHandler != null){
//			Message msg = new Message();
//			msg.what = 101;
//			Bundle bundle = new Bundle();
//			bundle.putString("content", value);
//	
//			msg.setData(bundle);
//			mHandler.sendMessage(msg);
//		}
	}

}
