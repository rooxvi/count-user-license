package io.ravi.countlicense.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERLICENSE")
public class UserLicense {

	@Id
	@Column(name = "COMPUTERID")
	private Long computerId;
	@Column(name = "USERID")
	private Long userId;
	@Column(name = "APPID")
	private Long appId;
	@Column(name = "COMPUTERTYPE")
	private String computerType;
	@Column(name = "COMMENTS")
	private String comments;

	public Long getComputerId() {
		return computerId;
	}

	public void setComputerId(Long computerId) {
		this.computerId = computerId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getComputerType() {
		return computerType;
	}

	public void setComputerType(String computerType) {
		this.computerType = computerType;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "UserLicense [computerId=" + computerId + ", userId=" + userId + ", appId=" + appId + ", computerType="
				+ computerType + ", comments=" + comments + "]";
	}

}
