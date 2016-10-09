package com.appframe.http.callback;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DownLoadCallback implements Callback{
	private static final String TAG = "DownLoadCallback";
	private Handler mHandler;
	
	private ImageView mImageView;
	
	public DownLoadCallback(){
		
	}
	
	public DownLoadCallback(Handler mHandler){
		this.mHandler = mHandler;
	}
	
	public DownLoadCallback(ImageView mImageView) {
		this.mImageView = mImageView;
	}
	
	public DownLoadCallback(ImageView mImageView, Handler mHandler) {
		this.mImageView = mImageView;
		this.mHandler = mHandler;
	}
	
	@Override
	public void onFailure(Call arg0, IOException arg1) {
		// TODO Auto-generated method stub
		Log.d(TAG, "下载文件失败" + arg1.getMessage());
		if (mHandler != null){
			Message msg = new Message();
			msg.what = 102;
		    Bundle bundle = new Bundle();
		    bundle.putString("message", arg1.getMessage());
	
		    msg.setData(bundle);
		    mHandler.sendMessage(msg);
		}
	}

	@Override
	public void onResponse(Call arg0, Response arg1) throws IOException {
		// TODO Auto-generated method stub
		int what = 101;
		String message = null;
		String content = arg1.header("content");
//		DownloadBean bean = GsonUtil.getGson().fromJson(content, DownloadBean.class);
//		if (bean == null) {
//			Log.d(TAG, "文件下载失败");
//			what = 102;
//            message = "文件下载失败";
//            if (mHandler != null){
//                Message msg = new Message();
//                msg.what = what;
//                Bundle bundle = new Bundle();
//                bundle.putString("message", message);
//
//                msg.setData(bundle);
//                mHandler.sendMessage(msg);
//            }
//			return;
//		}
//		String path = ToolUtil.getFileFullPath(bean.getLocalPath());
//		String name = bean.getName();
//		String wybs = bean.getUuid();
//		InputStream is = null;
//        byte[] buf = new byte[2048];
//        int len = 0;
//        FileOutputStream fos = null;
//        try {
//            is = arg1.body().byteStream();
//            File file = new File(path);
//            fos = new FileOutputStream(file);
//            while ((len = is.read(buf)) != -1) {
//                fos.write(buf, 0, len);
//            }
//            fos.flush();
//            
//            if (this.mImageView != null) {
////            	mImageView.setImageBitmap(Bimp.revitionImageSize(path));
//            }
//        } catch (Exception e) {
//            Log.d(TAG, "文件下载失败");
//            what = 102;
//            message = e.getMessage();
//        } finally {
//            try {
//                if (is != null)
//                    is.close();
//            } catch (IOException e) {
//            	what = 102;
//                message = e.getMessage();
//            }
//            try {
//                if (fos != null)
//                    fos.close();
//            } catch (IOException e) {
//            	what = 102;
//                message = e.getMessage();
//            }
//        }
//        
//        if (mHandler != null){
//            Message msg = new Message();
//            msg.what = what;
//            Bundle bundle = new Bundle();
//            bundle.putString("filename", name);
//            bundle.putString("path", path);
//            bundle.putString("wybs", wybs);
//            bundle.putString("message", message);
//
//            msg.setData(bundle);
//            mHandler.sendMessage(msg);
//        }
	}
}
