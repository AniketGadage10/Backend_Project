package com.app.DTO;

import javax.persistence.Column;

import com.app.entities.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Addressresponsedto {

	private Student sid;
	private String City;

	private String state;
	private String pincode;
}
