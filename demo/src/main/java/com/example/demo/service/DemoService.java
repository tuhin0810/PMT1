package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Case;
import com.example.demo.model.Process;
import com.example.demo.model.Task;
import com.example.demo.entity.Employee;

public interface DemoService {
	
	public  List<Employee> getEmployee(); 
	
	public void createProcess(Process process);
	
	public void createCase(Case bpmCase);
	
	public List<Case> getCaseByUser(String processOwner);
	
	public Task  completeActiveTask(String processId, String caseId, String taskParentId);
	
	public List<Task> retrieveCompletedTask(String processId, String caseId);
}
