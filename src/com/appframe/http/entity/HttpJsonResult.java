package com.appframe.http.entity;

public class HttpJsonResult extends HttpResult{
    private String content;
    private String datetime;
    
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(" context=" + content + "datetime=" + datetime);
      
        return sb.toString();
    }
}
