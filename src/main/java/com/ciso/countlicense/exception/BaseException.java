package com.ciso.countlicense.exception;

public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2597904155344767927L;

	private final String code;
	private final String desc;

	public BaseException(Errors error) {
		super(error.getDesc());
		this.code = error.getCode();
		this.desc = error.getDesc();
	}

	public BaseException(Errors error, String message) {
		super(message);
		this.code = error.getCode();
		this.desc = message;

	}

	public BaseException(Errors error, Exception ex) {
		super(error.getDesc(), ex);
		this.code = error.getCode();
		this.desc = error.getDesc();

	}

	public BaseException(Errors error, String message, Exception ex) {
		super(message, ex);
		this.code = error.getCode();
		this.desc = message;

	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

}
