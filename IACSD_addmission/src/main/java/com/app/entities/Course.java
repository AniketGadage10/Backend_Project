package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = "slist")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreType
public class Course extends Basenetity {
	@Enumerated(EnumType.STRING)
	private CourseEnum cname;
	@Column(nullable = false)
	private LocalDate start_date;
	@Column(nullable = false)
	private LocalDate end_date;
	@Column(nullable = false)
	private double fee;
	@Column(nullable = false)
	private double score;
	@OneToMany(mappedBy = "cid", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	private List<Student> slist = new ArrayList<>();

	public void insert(Student s)
	{
		slist.add(s);
		s.setCid(this);
	}
	
	public void delete(Student s)
	{
		slist.remove(s);
		s.setCid(null);
	}
}
