package com.app.service;

import java.util.List;

import com.app.DTO.Addressresponsedto;
import com.app.DTO.Apiresponse;
import com.app.DTO.CourseDTO;
import com.app.DTO.addressdto;
import com.app.entities.Course;
import com.app.entities.Student;

public interface addressservice {
	
	addressdto insertadd(addressdto adao) ;
	
	Addressresponsedto getdetails(Long sid);
}
