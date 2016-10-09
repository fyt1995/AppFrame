package com.appframe.http.entity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/** 
 * @author  Arvin: 
 * @version 2016年6月2日 下午4:10:09 
 * 
 */
@Root(name = "info",strict = false)
public class XmlEntity {

	@Text
    public String info;
    
	@Attribute
    public String sign;

    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }


    public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
}
