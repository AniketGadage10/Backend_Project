package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.CourseDTO;
import com.app.service.courseserviceimpl;

@RestController
@RequestMapping("/courses")
public class Coursecontroller {
	@Autowired
	private courseserviceimpl sser;

	@PostMapping
	public ResponseEntity<?> Insertcourse(@RequestBody CourseDTO c) {
		return ResponseEntity.status(HttpStatus.OK).body(sser.Insertcourse(c));
	}

	@GetMapping("/course_title/{cname}")
	public ResponseEntity<?> getlist(@PathVariable String cname) {
		System.out.println(cname);
		return ResponseEntity.status(HttpStatus.OK).body(sser.getlist(cname));
	}

	@PutMapping("/{cid}/fees/{fid}")
	public ResponseEntity<?> updatecourse(@PathVariable Long cid, @PathVariable double fid) {
		return ResponseEntity.status(HttpStatus.OK).body(sser.update(cid,fid));
	}

	@DeleteMapping("/{cid}/students/{sid}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long cid, @PathVariable Long sid)
	{
		return ResponseEntity.status(HttpStatus.OK).body(sser.DeleteStudent(cid,sid));

	}
}
