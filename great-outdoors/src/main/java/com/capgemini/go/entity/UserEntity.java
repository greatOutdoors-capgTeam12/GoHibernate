package com.capgemini.go.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	// attributes
	@Column(name = "USER_NAME", unique = false, nullable = false)
	private String userName;

	@Id
	@Column(name = "USER_ID", unique = true, nullable = false)
	private String userId;

	@Column(name = "USER_MAIL", unique = false, nullable = false)
	private String userMail;

	@Column(name = "USER_PASSWORD", unique = false, nullable = false)
	private String userPassword;

	@Column(name = "USER_CONTACT", unique = false, nullable = true)
	private Long userNumber;

	@Column(name = "USER_CATEGORY", unique = false, nullable = true)
	private int userCategory;

	@Column(name = "USER_ACTIVE_STATUS", unique = false, nullable = true)
	private boolean userActiveStatus;

	// getters
	public String getUserName() {
		return userName;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserMail() {
		return userMail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public Long getUserNumber() {
		return userNumber;
	}

	public int getUserCategory() {
		return userCategory;
	}

	public boolean isUserActiveStatus() {
		return userActiveStatus;
	}

	// setters

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserNumber(Long userNumber) {
		this.userNumber = userNumber;
	}

	public void setUserCategory(int userCategory) {
		this.userCategory = userCategory;
	}

	public void setUserActiveStatus(boolean userActiveStatus) {
		this.userActiveStatus = userActiveStatus;
	}

	// constructors
	public UserEntity() {

	}

	public UserEntity(String userName, String userId, String userMail, String userPassword, Long userNumber,
			int userCategory, boolean userActiveStatus) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.userNumber = userNumber;
		this.userCategory = userCategory;
		this.userActiveStatus = userActiveStatus;
	}

	@Override
	public String toString() {
		return "UserEntity [userName=" + userName + ", userId=" + userId + ", userMail=" + userMail + ", userPassword="
				+ userPassword + ", userNumber=" + userNumber + ", userCategory=" + userCategory + ", userActiveStatus="
				+ userActiveStatus + "]";
	}

}
