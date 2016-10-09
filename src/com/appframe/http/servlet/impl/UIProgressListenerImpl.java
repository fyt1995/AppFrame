package com.appframe.http.servlet.impl;

import com.appframe.http.servlet.UIProgressListener;

import android.util.Log;
import android.widget.ProgressBar;

/**
 * ui层回调
 * @author arvin
 *
 */
public class UIProgressListenerImpl extends UIProgressListener{

	private ProgressBar mProgressBar;
	
	public UIProgressListenerImpl(){
		
	}
	
	public UIProgressListenerImpl(ProgressBar mProgressBar){
		this.mProgressBar = mProgressBar;
	}
	
	@Override
	public void onUIProgress(long currentBytes, long contentLength, boolean done) {
		// TODO Auto-generated method stub
		Log.e("TAG", "bytesWrite:" + currentBytes + ", contentLength" + contentLength + "," + (100 * currentBytes) / contentLength + " % done ");
        
        if (contentLength != -1) {
            //长度未知的情况下回返回-1
            Log.e("TAG", (100 * currentBytes) / contentLength + "% done");
            int current = (int) ((100 * currentBytes) / contentLength);
            
            if (mProgressBar != null) {
            	mProgressBar.setProgress(current);
            }
        }
        Log.e("TAG", "================================");
	}
	
	@Override
    public void onUIStart(long bytesWrite, long contentLength, boolean done) {
        super.onUIStart(bytesWrite, contentLength, done);
    }

    @Override
    public void onUIFinish(long bytesWrite, long contentLength, boolean done) {
        super.onUIFinish(bytesWrite, contentLength, done);
    }
}
