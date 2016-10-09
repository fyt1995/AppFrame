package com.appframe.http.interceptor;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/** 
 * @author  Arvin
 * @version 2016-6-1 3:00:49 
 * 
 */
public class MarvelSigningInterceptor implements Interceptor {
	
    public MarvelSigningInterceptor() {

    }
    

    @Override 
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request oldRequest = chain.request();
//        boolean state = BankApplication.getAppState();
//        if (state){
//        	BankApplication.setAppState(false);
//        	return chain.proceed(oldRequest);
//        }
        
    	String content = oldRequest.url().queryParameter("content");
    	if (content == null || content.equals("")) {
        	content = "content";
        }
    	
    
        if (content.length() < 2000) {
	        // 添加新的参数
	        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
	                .newBuilder()
	                .scheme(oldRequest.url().scheme())
	                .host(oldRequest.url().host())
//	                .addQueryParameter("sign", sign)
//	                .addQueryParameter("token", token)
	                .setQueryParameter("content", content);
	
	        // 新的请求
	        Request newRequest = oldRequest.newBuilder()
	                .method(oldRequest.method(), oldRequest.body())
	                .url(authorizedUrlBuilder.build())
	                .header("User-Agent", "OkHttp Headers.java")
			        .addHeader("Accept", "application/json; q=0.5")
			        .addHeader("Accept", "application/vnd.github.v3+json")
	                .build();
	        return chain.proceed(newRequest);
        } else {
        	// 添加新的参数
	        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
	                .newBuilder()
	                .scheme(oldRequest.url().scheme())
	                .host(oldRequest.url().host())
	                
	                .setQueryParameter("content", null);
	
	        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                  .addFormDataPart("content", content)
//                  .addFormDataPart("upload", file.getName(), RequestBody.create(null, file))
//                  .addPart(Headers.of("Content-Disposition", "form-data; name=\"upload\";filename=\"1.png\""), 
//                  		RequestBody.create(MediaType.parse("application/octet-stream"), file))
                  .build();
	        
	        // 新的请求
	        Request newRequest = oldRequest.newBuilder()
	                .method(oldRequest.method(), requestBody)
	                .url(authorizedUrlBuilder.build())
	                .header("User-Agent", "OkHttp Headers.java")
			        .addHeader("Accept", "application/json; q=0.5")
			        .addHeader("Accept", "application/vnd.github.v3+json")
	                .build();
        	
        return chain.proceed(newRequest);
        }
    }
    
    /**
     * 读取requestBody内容
     * @param mRequest
     * @return
     */
    protected String getBody(Request mRequest) {
        RequestBody body = mRequest.body();
        Buffer buffer = new Buffer();
        try {
        	long len = mRequest.body().contentLength();
        	System.out.println("body:" + len);
			body.writeTo(buffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //编码设为UTF-8
//        Charset charset = new Charset("Charset");
        MediaType contentType = body.contentType();
        if (contentType != null) {
//          charset = contentType.charset(UTF8);
        }
        
        String content = buffer.readUtf8();
        
        return content;
    }
}
