package com.appframe.http.client;

import com.appframe.http.body.ProgressRequestBody;
import com.appframe.http.interceptor.DownloadInterceptor;
import com.appframe.http.interceptor.UploadInterceptor;
import com.appframe.http.servlet.ProgressListener;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

/**
 * 进度回调辅助类
 * @author arvin
 *
 */
public class ProgressHelper {
    /**
     * 包装OkHttpClient，用于下载文件的回调
     * @param client 待包装的OkHttpClient
     * @param progressListener 进度回调接口
     * @return 包装后的OkHttpClient，使用clone方法返回
     */
    public static OkHttpClient addProgressResponseListener(OkHttpClient client,final ProgressListener progressListener){
        //创建拦截器
//    	Interceptor interceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                //拦截
//                Response originalResponse = chain.proceed(chain.request());
//                //包装响应体并返回
//                return originalResponse.newBuilder()
//                        .body(new ProgressResponseBody(originalResponse.body(), progressListener))
//                        .build();
//            }
//        };
    	
    	DownloadInterceptor mDownloadInterceptor = new DownloadInterceptor(progressListener);
        return client.newBuilder()
                .addInterceptor(mDownloadInterceptor)
                .build();
    }
    
    public static OkHttpClient addProgressResponseListener(OkHttpClient client, RequestBody requestBody, ProgressListener mProgressListener){
    	UploadInterceptor mDownloadInterceptor = new UploadInterceptor(requestBody, mProgressListener);
        return client.newBuilder()
                .addInterceptor(mDownloadInterceptor)
                .build();
    }

    /**
     * 包装请求体用于上传文件的回调
     * @param requestBody 请求体RequestBody
     * @param progressRequestListener 进度回调接口
     * @return 包装后的进度回调请求体
     */
    public static ProgressRequestBody addProgressRequestListener(RequestBody requestBody,ProgressListener progressRequestListener){
        //包装请求体
        return new ProgressRequestBody(requestBody,progressRequestListener);
    }
}
