package com.appframe.exception;

/**
 * �쳣�׳���
 * @author Arvin
 *
 */
public class AronException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public AronException() {
		super();
	}
	
	public AronException(String msg) {
		super(msg);
	}
	
	public AronException(Throwable ex) {
		super(ex);
	}
	
	public AronException(String msg,Throwable ex) {
		super(msg,ex);
	}

}
