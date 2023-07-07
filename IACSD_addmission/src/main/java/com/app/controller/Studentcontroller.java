package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.StudentDTO;
import com.app.service.studentserviceimpl;

@RestController
@RequestMapping("/students")
@ResponseBody
public class Studentcontroller {
	@Autowired
	private studentserviceimpl sser;

	@PostMapping
	public ResponseEntity<?> insertStudent(@RequestBody StudentDTO sdto) {
		System.out.println(sdto.getC() + " " + sdto);
		return ResponseEntity.status(HttpStatus.OK).body(sser.insertstudent(sdto));
	}
}
