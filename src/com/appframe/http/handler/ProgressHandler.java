package com.appframe.http.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.lang.ref.WeakReference;

import com.appframe.http.entity.ProgressModel;
import com.appframe.http.servlet.UIProgressListener;

/**
 * 传输回调
 * @author arvin
 *
 */
public abstract class ProgressHandler extends Handler {
	/** 开始传输 **/
    public static final int UPDATE = 0x01;
    /** 开始传输 **/
    public static final int START = 0x02;
    /** 传输完成 **/
    public static final int FINISH = 0x03;
    /** 传输监听 **/
    private final WeakReference<UIProgressListener> mWeakReference;

    public ProgressHandler(UIProgressListener uiProgressListener) {
        super(Looper.getMainLooper());
        mWeakReference = new WeakReference<UIProgressListener>(uiProgressListener);
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case UPDATE: {
                UIProgressListener uiProgessListener = mWeakReference.get();
                if (uiProgessListener != null) {
                    //获得进度实体类
                    ProgressModel progressModel = (ProgressModel) msg.obj;
                    //回调抽象方法
                    progress(uiProgessListener, progressModel.getCurrentBytes(), progressModel.getContentLength(), progressModel.isDone());
                }
                break;
            }
            case START: {
                UIProgressListener uiProgressListener = mWeakReference.get();
                if (uiProgressListener != null) {
                    //获得进度实体类
                    ProgressModel progressModel = (ProgressModel) msg.obj;
                    //回调抽象方法
                    start(uiProgressListener, progressModel.getCurrentBytes(), progressModel.getContentLength(), progressModel.isDone());

                }
                break;
            }
            case FINISH: {
                UIProgressListener uiProgressListener = mWeakReference.get();
                if (uiProgressListener != null) {
                    //获得进度实体类
                    ProgressModel progressModel = (ProgressModel) msg.obj;
                    //回调抽象方法
                    finish(uiProgressListener, progressModel.getCurrentBytes(), progressModel.getContentLength(), progressModel.isDone());
                }
                break;
            }
            default:
                super.handleMessage(msg);
                break;
        }
    }
    
    /**
     * 开始传输
     * @param uiProgressListener
     * @param currentBytes
     * @param contentLength
     * @param done
     */
    public abstract void start(UIProgressListener uiProgressListener,long currentBytes, long contentLength, boolean done);
    
    /**
     * 更新传输进度
     * @param uiProgressListener
     * @param currentBytes
     * @param contentLength
     * @param done
     */
    public abstract void progress(UIProgressListener uiProgressListener,long currentBytes, long contentLength, boolean done);
    
    /**
     * 传输完成
     * @param uiProgressListener
     * @param currentBytes
     * @param contentLength
     * @param done
     */
    public abstract void finish(UIProgressListener uiProgressListener,long currentBytes, long contentLength, boolean done);
}
