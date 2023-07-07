package com.app.service;

import java.time.Period;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.Addressresponsedto;
import com.app.DTO.Apiresponse;
import com.app.DTO.CourseDTO;
import com.app.DTO.CourseResponseDTO;
import com.app.DTO.addressdto;
import com.app.entities.Address;
import com.app.entities.Course;
import com.app.entities.CourseEnum;
import com.app.entities.Student;
import com.app.exception.Addmissionexception;
import com.app.repository.AddressRepo;
import com.app.repository.CourseRepo;
import com.app.repository.StudentRepo;

@Service
@Transactional
public class addressserviceimpl implements addressservice {

	@Autowired
	private AddressRepo arepo;
	@Autowired
	private ModelMapper mp;
	@Autowired
	private StudentRepo srepo;

	public addressdto insertadd(addressdto adao) {

		Student s = srepo.findById(adao.getId()).orElseThrow(() -> new Addmissionexception("No Student By Id Exists"));

		Address a = mp.map(adao, Address.class);
		a.setSid(s);
		addressdto a1 = mp.map(arepo.save(a), addressdto.class);
		return a1;
	}

	public Addressresponsedto getdetails(Long sid) {
		Address a = arepo.findById(sid).orElseThrow(() -> new Addmissionexception("No Address By Id Exists"));;
		Addressresponsedto a1 = mp.map(a, Addressresponsedto.class);
		return a1;
	}

}
