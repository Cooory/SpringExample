package com.cooory.spring.ex.jpa.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Student {

	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	private String dreamJob;
	private Date createdAt;
	private Date updatedAt;
}
