package com.example.demo.model;

import java.util.List;

public class CaseResponse {
	private long processId;
	private long caseId;
	private long caseCreationDate;
	private String processOwner;
	private List<Task> taskList;
	private  String caseName;
	
	public long getProcessId() {
		return processId;
	}
	public void setProcessId(long processId) {
		this.processId = processId;
	}
	public long getCaseId() {
		return caseId;
	}
	public void setCaseId(long caseId) {
		this.caseId = caseId;
	}
	public long getCaseCreationDate() {
		return caseCreationDate;
	}
	public void setCaseCreationDate(long caseCreationDate) {
		this.caseCreationDate = caseCreationDate;
	}
	public String getProcessOwner() {
		return processOwner;
	}
	public void setProcessOwner(String processOwner) {
		this.processOwner = processOwner;
	}
	public List<Task> getTaskList() {
		return taskList;
	}
	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	@Override
	public String toString() {
		return "Case [processId=" + processId + ", caseId=" + caseId + ", caseCreationDate=" + caseCreationDate
				+ ", processOwner=" + processOwner + ", taskList=" + taskList + ", getProcessId()=" + getProcessId()
				+ ", getCaseId()=" + getCaseId() + ", getCaseCreationDate()=" + getCaseCreationDate()
				+ ", getProcessOwner()=" + getProcessOwner() + ", getTaskList()=" + getTaskList() + "]";
	}
	
	
	
}
