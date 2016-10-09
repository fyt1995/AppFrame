package com.appframe.http.client;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.appframe.http.entity.HttpResult;
import com.appframe.http.func.HttpJsonResultFunc;
import com.appframe.http.func.HttpResultFunc;
import com.appframe.http.interceptor.MarvelSigningInterceptor;
import com.appframe.http.servlet.ServletListener;
import com.appframe.rxjava.util.SubscriberUtil;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import android.os.Environment;


public class HttpMethodServlet {
    private static final int DEFAULT_TIMEOUT = 120;
    private static final int MINUTES = 6;

    private Retrofit retrofit;
    private ServletListener mServletService;
    
    /**
     * 单例模式
     * @author arvin
     *
     */
    private static class SingletonHolder{
        private static final HttpMethodServlet INSTANCE = new HttpMethodServlet();
    }

    public static HttpMethodServlet getInstance(){
        return SingletonHolder.INSTANCE;
    }

    /**
     * 私有构造方法
     */
    private HttpMethodServlet() {
        retrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())//gson
//                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(getUrl())
                
                .build();

        mServletService = retrofit.create(ServletListener.class);
    }
    
    private String getUrl() {
    	return "";
    }
    
    public void resetUrl(String url) {
    	retrofit = new Retrofit.Builder()
        .client(getOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())//gson
//        .addConverterFactory(SimpleXmlConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .baseUrl(getUrl())
        .build();

    	mServletService = retrofit.create(ServletListener.class);
    }
    
    /**
     * 手动创建一个OkHttpClient并设置超时时间
     * @return
     */
    private OkHttpClient getOkHttpClient(){

    	MarvelSigningInterceptor mMarvelSigningInterceptor = new MarvelSigningInterceptor();
    	OkHttpClient client = new OkHttpClient.Builder()
    		.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//    		.connectTimeout(1000, TimeUnit.MINUTES)
		    .readTimeout(1000, TimeUnit.MINUTES)
		    .writeTimeout(1000, TimeUnit.MINUTES)
    		.addInterceptor(mMarvelSigningInterceptor)
    		.build();
    	
    	return client;
    }

    /**
     * 
     * @param subscriber  由调用者传过来的观察者对象
     * @param start 起始位置
     * @param count 获取长度
     */
    public void getTopMovieJson(Subscriber<String> subscriber, String arg0){
        Observable<String> observable = mServletService.upLoadCjkhxx(arg0)
                .map(new HttpJsonResultFunc<String>());

        SubscriberUtil.toSubscribe(observable, subscriber);
    }
    
    /**
     * 登录
     * @param user
     * @return
     */
    public Observable<String> login(String val){
    	//登录时带上本地公有密钥
    	String publicKey = "";
    	return mServletService.login(val, publicKey).map(new HttpJsonResultFunc<String>());
    }
    
    /**
     * 获取令牌以及公有密钥
     * @param username
     * @return
     */
    public Observable<HttpResult> getTokenForLogin(String val){
    	return mServletService.getTokenForLogin(val).map(new HttpResultFunc<HttpResult>());
    }
    
    /**
     * 上传采集客户信息
     * @param content
     * @return
     */
    public Observable<String> upLoadCjkhxx(String content){
    	return mServletService.upLoadCjkhxx(content).map(new HttpJsonResultFunc<String>());
    }
    
    public Observable<String> getAllCjkhxx(String content){
    	return mServletService.getAllCjkhxx(content).map(new HttpJsonResultFunc<String>());
    }
    
    /**
     * 获取全部机构信息
     * @param content
     * @return
     */
    public Observable<String> getAllBm(String content){
    	return mServletService.getAllBm(content).map(new HttpJsonResultFunc<String>());
    }
    
    public Observable<String> upLoadDzcpPos(String content){
    	return mServletService.upLoadDzcpPos(content).map(new HttpJsonResultFunc<String>());
    }
    public Observable<String> serachDzcpkhxxpos(String content){
    	return mServletService.serachDzcpkhxxpos(content).map(new HttpJsonResultFunc<String>());
    }
    
    public Observable<String> upLoadDzcpEtc(String content){
    	return mServletService.upLoadDzcpEtc(content).map(new HttpJsonResultFunc<String>());
    }
    
    public Observable<String> getBbGx(String content){
    	return mServletService.getBbGx(content).map(new HttpJsonResultFunc<String>());
    }
    public Observable<String> getDzcpEtcListData(String content){
    	return mServletService.getDzcpEtcListData(content).map(new HttpJsonResultFunc<String>());
    }
    public Observable<String> serachXx(String content){
    	return mServletService.serachXx(content).map(new HttpJsonResultFunc<String>());
    }
    public Observable<String> getDzcpEtcYcjListData(String content){
    	return mServletService.getDzcpEtcYcjListData(content).map(new HttpJsonResultFunc<String>());
    }
    public Observable<String> getBdserach(String content){
    	return mServletService.getBdserach(content).map(new HttpJsonResultFunc<String>());
    }
    public Observable<String> getBdYcjserach(String content){
    	return mServletService.getBdYcjserach(content).map(new HttpJsonResultFunc<String>());
    }
    public Observable<String> getDzcpEtcUpListData(String content){
    	return mServletService.getDzcpEtcUpListData(content).map(new HttpJsonResultFunc<String>());
    }
    public Observable<String> getDzcpEtcYcjUpListData(String content){
    	return mServletService.getDzcpEtcYcjUpListData(content).map(new HttpJsonResultFunc<String>());
    }
    
    /********************主动营销***********************/
    
    public Observable<String> saveZdyxsb(String content) {
    	return mServletService.saveZdyxsb(content).map(new HttpJsonResultFunc<String>());
    }
    public Observable<String> findZdys(String content) {
    	return mServletService.findZdys(content).map(new HttpJsonResultFunc<String>());
    }
    public Observable<String> updataSBBL(String content) {
    	return mServletService.updataSBBL(content).map(new HttpJsonResultFunc<String>());
    }
    public Observable<String> pageZdyxsbList(String content) {
    	return mServletService.pageZdyxsbList(content).map(new HttpJsonResultFunc<String>());
    }
    
    /********************存款维护***********************/
    
    public Observable<String> pageCkwhList(String content) {
    	return mServletService.pageCkwhList(content).map(new HttpJsonResultFunc<String>());
    }
    
    public Observable<String> findCkwh(String content) {
    	return mServletService.findCkwh(content).map(new HttpJsonResultFunc<String>());
    }
    /********************存款拓展***********************/
    public Observable<String> pageCktzList(String content) {
    	return mServletService.pageCktzList(content).map(new HttpJsonResultFunc<String>());
    }
    
    public Observable<String> findCktz(String content) {
    	return mServletService.findCktz(content).map(new HttpJsonResultFunc<String>());
    }
    /********************贷款管护***********************/
    public Observable<String> pageDkghList(String content) {
    	return mServletService.pageDkghList(content).map(new HttpJsonResultFunc<String>());
    }
    
    public Observable<String> findDkgh(String content) {
    	return mServletService.findDkgh(content).map(new HttpJsonResultFunc<String>());
    }
    
    public Observable<String> pageDkghAcList(String content) {
    	return mServletService.pageDkghAcList(content).map(new HttpJsonResultFunc<String>());
    }
    
	public Observable<String> pageDkbsList(String content) {
		return mServletService.pageDkbsList(content).map(new HttpJsonResultFunc<String>());
	}

    public Observable<String> findDkbsdj(String content) {
    	return mServletService.findDkbsdj(content).map(new HttpJsonResultFunc<String>());
    }
	
    public Observable<String> pageDkbsdjAcList(String content) {
    	return mServletService.pageDkbsdjAcList(content).map(new HttpJsonResultFunc<String>());
    }
    
    /********************数据同步***********************/
    public Observable<String> getCanshu() {
    	return mServletService.getCanshu("content").map(new HttpJsonResultFunc<String>());
    }
    
    public Observable<String> getYhForUpdate(String content) {
    	return mServletService.getYhForUpdate(content).map(new HttpJsonResultFunc<String>());
    }
    
    public Observable<String> uploadFile() {
    	File file = new File(Environment.getExternalStorageDirectory(), "icon.png");
    	RequestBody photoRequestBody = RequestBody.create(MediaType.parse("image/png"), file);
    	MultipartBody.Part photo = MultipartBody.Part.createFormData("photos", "icon.png", photoRequestBody);
    	
//    	return mServletService.uploadFiles(photo, RequestBody.create(null, "abc"), RequestBody.create(null, "123"));
    	return mServletService.uploadFile(RequestBody.create(null, "abc"), RequestBody.create(null, "123")).map(new HttpJsonResultFunc<String>());
    }
    
    public Observable<String> uploadFiles() {
    	File file = new File(Environment.getExternalStorageDirectory(), "messenger_01.png");
        RequestBody photo = RequestBody.create(MediaType.parse("image/png"), file);
        
        Map<String,RequestBody> photos = new HashMap<String,RequestBody>();
        photos.put("photos\"; filename=\"icon.png", photo);
        photos.put("username",  RequestBody.create(null, "abc"));
        
        return mServletService.uploadFiles(photos, RequestBody.create(null, "123")).map(new HttpJsonResultFunc<String>());
    	
    }
    //
    public Observable<String> saveTjSyJyb(String content){
    	return mServletService.saveTjSyJyb(content).map(new HttpJsonResultFunc<String>());
    }
}
