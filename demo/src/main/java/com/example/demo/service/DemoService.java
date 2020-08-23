package com.example.demo.service;

import java.util.List;

import com.example.demo.model.CaseRequest;
import com.example.demo.model.CaseResponse;
import com.example.demo.model.Process;
import com.example.demo.model.Task;
import com.example.demo.entity.Employee;

public interface DemoService {
	
	public  List<Employee> getEmployee(); 
	
	public void createProcess(Process process);
	
	public void createCase(CaseRequest bpmCase);
	
	public List<CaseResponse> getCaseByUser(String processOwner);
	
	public Task  completeActiveTask(long processId, long caseId, long taskParentId);
	
	public List<Task> retrieveCompletedTask(long processId, long caseId);
}
