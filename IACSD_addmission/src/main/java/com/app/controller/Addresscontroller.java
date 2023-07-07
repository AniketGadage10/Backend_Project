package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.addressdto;
import com.app.service.addressserviceimpl;

@RestController
@RequestMapping("/address")
public class Addresscontroller {

	@Autowired
	private addressserviceimpl aser;
	
	@PostMapping
	public ResponseEntity<?> insertAdd(@RequestBody addressdto adao)
	{
		return ResponseEntity.status(HttpStatus.OK).body(aser.insertadd(adao));
	}
	
	@GetMapping("/{sid}")
	public ResponseEntity<?> getfulldetails(@PathVariable Long sid) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(aser.getdetails(sid));
	}
	
}
