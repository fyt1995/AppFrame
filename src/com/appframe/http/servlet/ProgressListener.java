package com.appframe.http.servlet;

/**
 * 进度回调接口，比如用于文件上传与下载
 * @author arvin
 *
 */
public interface ProgressListener {
	/**
	 * 传输进度
	 * @param currentBytes
	 * @param contentLength
	 * @param done
	 */
    void onProgress(long currentBytes, long contentLength, boolean done);
}