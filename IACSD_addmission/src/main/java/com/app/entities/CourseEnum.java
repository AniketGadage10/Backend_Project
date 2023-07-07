package com.app.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public enum CourseEnum {
	JAVA_BEGINER,JAVA_ADVANCED;	
	private CourseEnum() {
	}	
}
