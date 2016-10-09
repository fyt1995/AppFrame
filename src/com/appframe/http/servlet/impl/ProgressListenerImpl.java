package com.appframe.http.servlet.impl;

import com.appframe.http.servlet.ProgressListener;

import android.util.Log;

public class ProgressListenerImpl implements ProgressListener{

	@Override
	public void onProgress(long currentBytes, long contentLength, boolean done) {
		// TODO Auto-generated method stub
		Log.e("TAG", "bytesRead:" + currentBytes + "contentLength:" + contentLength);
        if (contentLength != -1) {
            //长度未知的情况下回返回-1
            Log.e("TAG", (100 * currentBytes) / contentLength + "% done");
        }
        Log.e("TAG", "done:" + done +"================================");
	}

}
