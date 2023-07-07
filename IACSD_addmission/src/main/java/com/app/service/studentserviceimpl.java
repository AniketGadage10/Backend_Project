package com.app.service;

import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.DTO.Apiresponse;
import com.app.DTO.StudentDTO;
import com.app.entities.Course;
import com.app.entities.CourseEnum;
import com.app.entities.Student;
import com.app.exception.Addmissionexception;
import com.app.repository.CourseRepo;
import com.app.repository.StudentRepo;

@Service
@Transactional
public class studentserviceimpl implements studentservice {
	@Autowired
	private StudentRepo srepo;
	@Autowired
	private CourseRepo crepo;
	@Autowired
	private ModelMapper mp;
	

	public Apiresponse insertstudent(StudentDTO sdto) {
		System.out.println(sdto.getC());
		CourseEnum nm=CourseEnum.valueOf(sdto.getC());
		Course course = crepo.findByCname(nm).orElseThrow(() -> new Addmissionexception("Course Not Found "));
		Student s = mp.map(sdto, Student.class);
		if (s.getScore() > course.getScore()) {
			course.insert(s);
			srepo.save(s);
			return new Apiresponse("STUDENT INSERTED SUCESSFULLY");
		}
		return new Apiresponse("Student Has Less Scored Then Required");
	}
}
