package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.model.CaseRequest;
import com.example.demo.model.CaseResponse;
import com.example.demo.model.Process;
import com.example.demo.model.Task;
import com.example.demo.service.DemoService;

@Controller
public class DemoController {
	
	@Autowired 
	private DemoService service;
	
	@GetMapping(value="/retrieve",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> index() {
		return new ResponseEntity<Object>(service.getEmployee(), HttpStatus.OK);
	}
	
	@PostMapping(value="/create/process",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createProcess(@RequestBody Process process){
		service.createProcess(process);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/create/case", produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createCase(@RequestBody CaseRequest cases){
		service.createCase(cases);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/retrieve/case/byUser/{processOwner}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CaseResponse>> retrieveCaseByUser(@PathVariable("processOwner") String processOwner){		
		return new ResponseEntity<List<CaseResponse>>(service.getCaseByUser(processOwner),HttpStatus.OK);
	}
	
	@GetMapping(value = "/retrieve/completed/task/{processId}/{caseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Task>> retrieveCompletedTask(@PathVariable("processId") long processId,
			@PathVariable("caseId") long caseId){	
		return new ResponseEntity<List<Task>>(service.retrieveCompletedTask(processId, caseId),HttpStatus.OK);
	}
	
	@PutMapping(value = "/complete/task/{processId}/{caseId}/{taskParentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> completeTask(@PathVariable("processId") long processId,
			@PathVariable("caseId") long caseId, @PathVariable("taskParentId") long taskParentId)	{
		return new ResponseEntity<Task>(service.completeActiveTask(processId, caseId, taskParentId),HttpStatus.OK);
	}

}
