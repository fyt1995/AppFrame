package com.appframe.rxjava.util;

import com.appframe.rxjava.listener.ProgressCancelListener;
import com.appframe.rxjava.listener.SubscriberOnNextListener;
import com.google.gson.stream.MalformedJsonException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {

    private SubscriberOnNextListener<T> mSubscriberOnNextListener;

    public ProgressSubscriber(SubscriberOnNextListener<T> mSubscriberOnNextListener) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
    }
    
    @Override
    public void onStart() {
    }

    @Override
    public void onCompleted() {
    	 if (mSubscriberOnNextListener != null) {
         	mSubscriberOnNextListener.completed();;
         }
    	 
    	 this.onCancelProgress();
    }

    @Override
    public void onError(Throwable e) {
    	String val = null;
        if (e instanceof SocketTimeoutException) {
        	val = "网络超时" + e.getMessage();
        } else if (e instanceof ConnectException) {
        	val = "网络连接失败" + e.getMessage();
        } else if (e instanceof MalformedJsonException) {
        	val = "json格式转换错误" + e.getMessage();
        } else {
            val = e.getMessage();
        }
        
        if (mSubscriberOnNextListener != null) {
        	mSubscriberOnNextListener.error(val);
        }
        
        this.onCancelProgress();
    }

    @Override
    public void onNext(T t) {
        if (mSubscriberOnNextListener != null) {
            mSubscriberOnNextListener.onNext(t);
        }
    }

    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }
}