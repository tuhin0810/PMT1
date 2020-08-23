package com.example.demo.model;

import java.util.List;


public class CaseRequest {
	private long processId;
	private long caseCreationDate;
	private String processOwner;
	private  String caseName;
	
	public long getProcessId() {
		return processId;
	}
	public void setProcessId(long processId) {
		this.processId = processId;
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


	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	@Override
	public String toString() {
		return "CaseRequest [processId=" + processId + ", caseCreationDate=" + caseCreationDate + ", processOwner="
				+ processOwner + ", caseName=" + caseName + ", getProcessId()=" + getProcessId()
				+ ", getCaseCreationDate()=" + getCaseCreationDate() + ", getProcessOwner()=" + getProcessOwner()
				+ ", getCaseName()=" + getCaseName() + "]";
	}

	
	
}
