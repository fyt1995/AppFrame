package com.appframe.http.entity;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/** 
 * @author  Arvin: 
 * @version 2016年6月2日 下午4:09:27 
 * 
 */

@Root(name = "data",strict = false)
public class HttpXmlResult {
	@ElementList(required = true,inline = true,entry = "info")

    public List<XmlEntity> list;

    public List<XmlEntity> getList() {
        return list;
    }

    public void setList(List<XmlEntity> list) {
        this.list = list;
    }
}
