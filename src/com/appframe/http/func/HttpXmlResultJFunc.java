package com.appframe.http.func;

import com.appframe.http.exception.HttpException;

import rx.functions.Func1;

/** 
 * @author  Arvin: 
 * @version 2016年5月28日 上午9:09:08 
 * 
 */
public class HttpXmlResultJFunc<T> implements Func1<T, T>{

    @Override
    public T call(T t) {
        if (t == null) {
            throw new HttpException(100);
        }
        return t;
    }
}
