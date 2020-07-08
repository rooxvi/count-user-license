package com.ciso.countlicense.dto;

public class UserLicenseDto {

	private Long computerId;
	private Long userId;
	private Long appId;
	private String computerType;

	public Long getComputerId() {
		return computerId;
	}

	public UserLicenseDto setComputerId(Long computerId) {
		this.computerId = computerId;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public UserLicenseDto setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public Long getAppId() {
		return appId;
	}

	public UserLicenseDto setAppId(Long appId) {
		this.appId = appId;
		return this;
	}

	public String getComputerType() {
		return computerType;
	}

	public UserLicenseDto setComputerType(String computerType) {
		this.computerType = computerType;
		return this;
	}

	@Override
	public String toString() {
		return "LicenseDto [computerId=" + computerId + ", userId=" + userId + ", appId=" + appId + ", computerType="
				+ computerType + "]";
	}

}
