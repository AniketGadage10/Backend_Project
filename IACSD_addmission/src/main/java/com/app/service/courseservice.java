package com.app.service;

import java.util.List;

import com.app.DTO.Apiresponse;
import com.app.DTO.CourseDTO;
import com.app.entities.Course;
import com.app.entities.Student;

public interface courseservice {
	Course Insertcourse(CourseDTO c);
	
	 List<Student> getlist(String cname);
	 
	 Apiresponse DeleteStudent(Long cid, Long sid);
}
