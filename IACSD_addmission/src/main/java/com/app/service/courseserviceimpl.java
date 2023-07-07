package com.app.service;

import java.time.Period;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.Apiresponse;
import com.app.DTO.CourseDTO;
import com.app.DTO.CourseResponseDTO;
import com.app.entities.Course;
import com.app.entities.CourseEnum;
import com.app.entities.Student;
import com.app.exception.Addmissionexception;
import com.app.repository.CourseRepo;
import com.app.repository.StudentRepo;

@Service
@Transactional
public class courseserviceimpl implements courseservice {

	@Autowired
	private CourseRepo crepo;
	
	@Autowired
	private StudentRepo srepo;
	@Autowired
	private ModelMapper mp;

	public Course Insertcourse(CourseDTO c) {
		int m = Period.between(c.getStart_date(), c.getEnd_date()).getMonths();
		int y = Period.between(c.getStart_date(), c.getEnd_date()).getYears();
		if (y >= 0 && m > 1) {
			Course course = mp.map(c, Course.class);
			Course c1 = crepo.save(course);
			return c1;
		}
		throw new Addmissionexception("Wrong Date Input");
	}

	public List<Student> getlist(String cname) {

		Course c = crepo.findByCname(CourseEnum.valueOf(cname))
				.orElseThrow(() -> new Addmissionexception("Course Not Found"));
		return c.getSlist();
	}

	public CourseResponseDTO update(Long cid, double fid) {
		Course c = crepo.findById(cid).orElseThrow(() -> new Addmissionexception("Course Not Found"));
		c.setFee(fid);
		Course c1 = crepo.save(c);
		CourseResponseDTO p = mp.map(c1, CourseResponseDTO.class);
		return p;
	}

	public Apiresponse DeleteStudent(Long cid, Long sid) {
		Course c = crepo.findById(cid).orElseThrow(() -> new Addmissionexception("Course Not Found"));
		Student s=srepo.findById(sid).orElseThrow(() -> new Addmissionexception("Student Not Found"));
		c.delete(s);
		return new Apiresponse("Student Deletion Sucessfull");
	}
}
