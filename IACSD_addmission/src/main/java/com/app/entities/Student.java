package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Basenetity{
	@Column(length = 20)
	private String fname;
	@Column(length = 20)
	private String lname;
	@Column(length = 50)
	private String email;
	@Column(nullable = false)
	private double score;
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course cid;
	
}
