package com.appframe.rxjava.listener;

/**
 * 取消网络访问接口
 * @author Administrator
 *
 */
public interface ProgressCancelListener {
	/**
	 * 取消访问
	 */
    void onCancelProgress();
}
