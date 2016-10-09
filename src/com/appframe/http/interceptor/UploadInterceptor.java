package com.appframe.http.interceptor;

import java.io.IOException;

import com.appframe.http.client.ProgressHelper;
import com.appframe.http.servlet.ProgressListener;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/** 
 * @author  Arvin
 * @version 2016-6-1 3:00:49 
 * 
 */
public class UploadInterceptor implements Interceptor {

	private RequestBody requestBody;
	
	private ProgressListener mProgressListener;
	
	public UploadInterceptor(RequestBody requestBody, ProgressListener mProgressListener) {
		this.requestBody = requestBody;
		this.mProgressListener = mProgressListener;
    }

    @Override 
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request oldRequest = chain.request();
        String content = oldRequest.url().queryParameter("content");
        if (content == null || content.equals("")) {
        	content = "content";
        }

        // 添加新的参数
        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                .newBuilder()
                .scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host())
                
                .setQueryParameter("content", content);

      //进行包装，使其支持进度回调
        final Request request = oldRequest.newBuilder()
        		.url(authorizedUrlBuilder.build())
        		.post(ProgressHelper.addProgressRequestListener(requestBody, mProgressListener))
        		.build();
        
        return chain.proceed(request);
    }
}
