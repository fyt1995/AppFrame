package com.appframe.rxjava.util;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/** 
 * @author  Arvin: 
 * @version 2016年5月28日 上午9:28:11 
 * 
 */
public class SubscriberUtil {
	public static <T> void toSubscribe(Observable<T> mObservable, Subscriber<T> mSubscriber){
    	mObservable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mSubscriber);
    }
}
