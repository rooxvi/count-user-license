package io.ravi.countlicense.exception;

public class UserNotFoundException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7209961053614574181L;

	public UserNotFoundException(Errors error) {
		super(error);
	}

}
