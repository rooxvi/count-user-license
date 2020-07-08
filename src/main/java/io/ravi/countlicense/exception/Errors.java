package io.ravi.countlicense.exception;

public enum Errors {

	USERNOTFOUND("001", "Requested user not found");

	private String code;
	private String desc;

	private Errors(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

}
