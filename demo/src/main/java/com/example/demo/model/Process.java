package com.example.demo.model;

import java.util.List;



public class Process {

	
	private String processOwner;
	private String processName;
	private List<ProcessTask> processTask;
	
	public String getProcessOwner() {
		return processOwner;
	}
	public void setProcessOwner(String processOwner) {
		this.processOwner = processOwner;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public List<ProcessTask> getProcessTask() {
		return processTask;
	}
	public void setProcessTask(List<ProcessTask> processTask) {
		this.processTask = processTask;
	}	
}
