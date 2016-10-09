package com.appframe.http.func;

import com.appframe.http.entity.HttpJsonResult;
import com.appframe.http.exception.HttpException;

import rx.functions.Func1;

/** 
 * @author  Arvin: 
 * @version 2016年5月28日 上午9:09:08 
 * 
 */
public class HttpJsonResultFunc<T> implements Func1<HttpJsonResult, String>{
	
    @Override
    public String call(HttpJsonResult t) {
        if (t == null) {
            throw new HttpException(100);
        }
        if (t.getState() == 200){
	        String sign = t.getSign();
	        String content = t.getContent();
	        
//			String privateKey = TAppTokenModel.getPrivateKey();
//			String publicKey = TAppTokenModel.getPublicKeyForServer();
//			
//	        boolean isTrue = CodeUtil.isVerify(content, sign, publicKey);
//	        String value = null;
//	        if (isTrue){
//	        	value = CodeUtil.decryptForLong(content, privateKey);
//	        } else {
//	        	throw new HttpException(400);
//	        }
	        return content;
        } else{
        	HttpException mHttpException = new HttpException(t.getState() + t.getMessage());
        	throw mHttpException;
        }
    }
}
