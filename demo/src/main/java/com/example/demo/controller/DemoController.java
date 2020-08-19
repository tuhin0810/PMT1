package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.DemoService;

@Controller
public class DemoController {
	
	@Autowired 
	private DemoService service;
	
	@GetMapping(value="/retrieve",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> index() {
		return new ResponseEntity<Object>(service.getEmployee(), HttpStatus.OK);
	}

}
