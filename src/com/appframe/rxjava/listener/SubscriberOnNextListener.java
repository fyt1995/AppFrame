package com.appframe.rxjava.listener;

/**
 * rxandroid响应接口
 * @author arvin
 *
 * @param <T>
 */
public interface SubscriberOnNextListener<T> {
	/**
	 * 回调事件
	 * @param t
	 */
    void onNext(T t);

    /**
     * 成功回调
     */
    void completed();
    
    
    /**
     * 失败回调
     * @param arg0
     */
    void error(String arg0);
    
}
