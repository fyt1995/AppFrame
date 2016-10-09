package com.appframe.http.func;

import java.util.Date;

import com.appframe.http.entity.HttpResult;
import com.appframe.http.exception.HttpException;

import rx.functions.Func1;

/** 
 * @author  Arvin
 * @version 2016-5-28 9:09:08 
 * 
 */
public class HttpResultFunc<T> implements Func1<HttpResult, HttpResult>{
	
    @Override
    public HttpResult call(HttpResult t) {
        if (t == null) {
            throw new HttpException(100);
        }
        
        if (t.getState() == 200) {
//	        TAppToken token = new TAppToken();
//	    	token.setSPublicKey(t.getPublicKey());
//	    	token.setToken(t.getToken());
//	    	token.setCjsj(new Date());
//
//	        //生成key
//	        TAppTokenModel.newClientKey();
//	    	TAppTokenModel.savePublicKey(t.getPublicKey(), t.getToken());
	    } else{
	    	HttpException mHttpException = new HttpException(t.getState() + t.getMessage());
	    	throw mHttpException;
	    }

        return t;
    }
    
}
