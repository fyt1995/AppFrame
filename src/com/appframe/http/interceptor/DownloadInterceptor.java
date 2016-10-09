package com.appframe.http.interceptor;

import java.io.IOException;

import com.appframe.http.body.ProgressResponseBody;
import com.appframe.http.servlet.ProgressListener;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/** 
 * @author  Arvin
 * @version 2016-6-1 3:00:49 
 * 
 */
public class DownloadInterceptor implements Interceptor {

	private ProgressListener progressListener;
	
    public DownloadInterceptor(ProgressListener progressListener) {
    	this.progressListener = progressListener;
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

        // 新的请求
        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(authorizedUrlBuilder.build())
                .header("User-Agent", "OkHttp Headers.java")
//		        .addHeader("Accept", "application/json; q=0.5")
//		        .addHeader("Accept", "application/vnd.github.v3+json")
                .build();

        Response originalResponse = chain.proceed(newRequest);
        
        //包装响应体并返回
        return originalResponse.newBuilder()
              .body(new ProgressResponseBody(originalResponse.body(), progressListener))
              .build();
      
//        return chain.proceed(newRequest);
    }
}
