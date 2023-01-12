package com.cg.membermanipulation.MemberManipulation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;

@Document
public class Member {


	@NotNull(message = "memberId must not be null")
	private int memberId;
	@NotNull(message = "memberName must not be null")
	private String memberName;
	@NotNull(message = "address must not be null")
	private String address;
	
	public Member(int memberId, String memberName, String address) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.address = address;
	}

	public Member() {
		super();
	}

	

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
