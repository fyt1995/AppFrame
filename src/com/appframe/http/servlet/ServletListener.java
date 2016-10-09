package com.appframe.http.servlet;

import java.util.Map;

import com.appframe.http.entity.HttpJsonResult;
import com.appframe.http.entity.HttpResult;

import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 网络接口
 * @author arvin
 *
 */
public interface ServletListener {
    
    /**
     * 登陆获取令牌
     * @param token
     * @return
     */
    @GET("coder/coderOperate!loginByToken.do")
    Observable<HttpJsonResult> loginByToken(@Query("token") String token);
    
    /**
     * 获取部门信息接口
     * @param content
     * @return
     */
    @POST("bank/tXtBmOperate!getAllBm.do")
    Observable<HttpJsonResult> getAllBm(@Query("content") String content);
    
    /**
     * 登录时获取
     * @param token
     * @return
     */
    @GET("coder/coderOperate!getTokenForLogin.do")
    Observable<HttpResult> getTokenForLogin(@Query("username") String username);
    
    /**
     * 登录接口
     * @param content
     * @return
     */
    @GET("bank/loginOperate!login.do")
    Observable<HttpJsonResult> login(@Query("content") String content, @Query("clientPublicKey") String clientPublicKey);
    
    /**
     * 获取修改的用户数据
     * @param conetnt
     * @return
     */
    @GET("bank/loginOperate!getYhForUpdate.do")
    Observable<HttpJsonResult> getYhForUpdate(@Query("content") String conetnt);
    
    /**
     * 采集客户记录数据同步接口
     * @param content
     * @return
     */
    @POST("bank/tAppBfrjKhjbxxbOperate!saveBfrjInfo.do")
    Observable<HttpJsonResult> upLoadCjkhxx(@Query("content") String content);
    
    /**
     * 获取所有采集信息
     * @param content
     * @return
     */
    @POST("bank/tAppBfrjKhjbxxbOperate!getBfrjInfo.do")
    Observable<HttpJsonResult> getAllCjkhxx(@Query("content") String content);
    
    /**
     * 电子产品POS同步接口
     * @param content
     * @return
     */
    @POST("bank/dzcpOperate!saveDzcpPos.do")
    Observable<HttpJsonResult> upLoadDzcpPos(@Query("content") String content);
    
    @POST("bank/dzcpOperate!serachDzcpkhxxpos.do")
    Observable<HttpJsonResult> serachDzcpkhxxpos(@Query("content") String content);
    
    /**
     * 电子产品ETC同步接口
     * @param content
     * @return
     */
    @POST("bank/dzcpOperate!saveDzcpEtc.do")
    Observable<HttpJsonResult> upLoadDzcpEtc(@Query("content") String content);
    
    /**
     * 电子产品ETC同步接口
     * @param content
     * @return
     */
    @POST("bank/tAppSyjybOperate!saveTjSyJyb.do")
    Observable<HttpJsonResult> saveTjSyJyb(@Query("content") String content);
    /**
     * 系统版本更新接口
     * @param content
     * @return
     */
    @GET("bank/tAppAppbOperate!getBbGx.do")
    Observable<HttpJsonResult> getBbGx(@Query("content") String content);
    /**
     * etc ,listView列表未成交新接口
     * @param content
     * @return
     */
    @GET("bank/dzcpOperate!getDzcpEtcListData.do")
    Observable<HttpJsonResult> getDzcpEtcListData(@Query("content") String content);
    /**
     * etc ,listView列表未成交接口
     * @param content
     * @return
     */
    @GET("bank/dzcpOperate!getDzcpEtcYcjListData.do")
    Observable<HttpJsonResult> getDzcpEtcYcjListData(@Query("content") String content);
    /**
     * etc ,listView表单未成交查询接口
     * @param content
     * @return
     */
    @GET("bank/dzcpOperate!getBdserach.do")
    Observable<HttpJsonResult> getBdserach(@Query("content") String content);
    /**
     * etc ,listView表单已成交查询接口
     * @param content
     * @return
     */
    @GET("bank/dzcpOperate!getBdYcjserach.do")
    Observable<HttpJsonResult> getBdYcjserach(@Query("content") String content);
    /**
     * 系统版本更新接口
     * @param content
     * @return
     */
    @GET("bank/dzcpOperate!serachXx.do")
    Observable<HttpJsonResult> serachXx(@Query("content") String content);
    
    /******************主动营销*****************/
    /**
     * etc ,listView列表未成交下拉新接口
     * @param content
     * @return
     */
    @GET("bank/dzcpOperate!getDzcpEtcUpListData.do")
    Observable<HttpJsonResult> getDzcpEtcUpListData(@Query("content") String content);
    /**
     * etc ,listView列表已成交下拉刷新接口
     * @param content
     * @return
     */
    @GET("bank/dzcpOperate!getDzcpEtcYcjUpListData.do")
    Observable<HttpJsonResult> getDzcpEtcYcjUpListData(@Query("content") String content);
    /**
     * 保存主动营销
     * @param content
     * @return
     */
    @GET("bank/tZdyxsbbOperate!saveZdyxsb.do")
    Observable<HttpJsonResult> saveZdyxsb(@Query("content") String content);
    
    /**
     * 查找主动营销
     * @param content
     * @return
     */
    @GET("bank/tZdyxsbbOperate!findZdys.do")
    Observable<HttpJsonResult> findZdys(@Query("content") String content);
    
    /**
     * 更新申报比例
     * @param content
     * @return
     */
    @GET("bank/tZdyxsbbOperate!updataSBBL.do")
    Observable<HttpJsonResult> updataSBBL(@Query("content") String content);

    /**
     * 查询营销数据
     * @param content
     * @return
     */
    @GET("bank/tZdyxsbbOperate!pageZdyxsbList.do")
    Observable<HttpJsonResult> pageZdyxsbList(@Query("content") String content);
    
    @GET("bank/tXtCanshuOperate!getCanshu.do")
    Observable<HttpJsonResult> getCanshu(@Query("content") String conetnt);
    
    @GET("bank/tCkwhOperate!pageCkwhList.do")
    Observable<HttpJsonResult> pageCkwhList(@Query("content") String content);
    
    @GET("bank/tCkwhOperate!findCkwh.do")
    Observable<HttpJsonResult> findCkwh(@Query("content") String conetnt);
    
    @GET("bank/tCktuozhanOperate!pageCktzList.do")
    Observable<HttpJsonResult> pageCktzList(@Query("content") String content);
    
    @GET("bank/tCktuozhanOperate!findCktz.do")
    Observable<HttpJsonResult> findCktz(@Query("content") String conetnt);
    
    @GET("bank/tDkghdjbOperate!pageDkghList.do")
    Observable<HttpJsonResult> pageDkghList(@Query("content") String content);
    
    @GET("bank/tDkghdjbOperate!findDkgh.do")
    Observable<HttpJsonResult> findDkgh(@Query("content") String conetnt);
    
    /**  **/
    @GET("bank/tDkghdjbOperate!pageDkghAcList.do")
	Observable<HttpJsonResult> pageDkghAcList(@Query("content") String conetnt);
    
    /** 贷款包收列表 **/
	@GET("bank/tDkbsdjbOperate!pageDkbsList.do")
    Observable<HttpJsonResult> pageDkbsList(@Query("content") String conetnt);

	/** 贷款包细明细 **/
	@GET("bank/tDkbsdjbOperate!findDkbsdj.do")
    Observable<HttpJsonResult> findDkbsdj(@Query("content") String conetnt);
	
	/**  **/
	@GET("bank/tDkbsdjbOperate!pageDkbsdjAcList.do")
	Observable<HttpJsonResult> pageDkbsdjAcList(@Query("content") String conetnt);
	
    @Multipart
    @POST
    Observable<HttpJsonResult> uploadFile(@Part("username") RequestBody username, @Part("password") RequestBody password);
    
    @Multipart
    @POST("register")
    Observable<HttpJsonResult> uploadFiles(@PartMap Map<String, RequestBody> params,  @Part("password") RequestBody password);
}
