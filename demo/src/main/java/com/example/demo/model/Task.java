package com.example.demo.model;

public class Task {
	
	private long procesId;
	private long caseId;
	private long taskParentId;
	private String taskName;
	private long creationTime;
	private long completionTime;
	private long flowDirectivity;
	
	public long getProcesId() {
		return procesId;
	}
	public void setProcesId(long procesId) {
		this.procesId = procesId;
	}
	public long getCaseId() {
		return caseId;
	}
	public void setCaseId(long caseId) {
		this.caseId = caseId;
	}
	public long getTaskParentId() {
		return taskParentId;
	}
	public void setTaskParentId(long taskParentId) {
		this.taskParentId = taskParentId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public long getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}
	public long getCompletionTime() {
		return completionTime;
	}
	public void setCompletionTime(long completionTime) {
		this.completionTime = completionTime;
	}
	public long getFlowDirectivity() {
		return flowDirectivity;
	}
	public void setFlowDirectivity(long flowDirectivity) {
		this.flowDirectivity = flowDirectivity;
	}
	
	@Override
	public String toString() {
		return "Task [procesId=" + procesId + ", caseId=" + caseId + ", taskParentId=" + taskParentId + ", taskName="
				+ taskName + ", creationTime=" + creationTime + ", completionTime=" + completionTime
				+ ", flowDirectivity=" + flowDirectivity + ", getProcesId()=" + getProcesId() + ", getCaseId()="
				+ getCaseId() + ", getTaskParentId()=" + getTaskParentId() + ", getTaskName()=" + getTaskName()
				+ ", getCreationTime()=" + getCreationTime() + ", getCompletionTime()=" + getCompletionTime()
				+ ", getFlowDirectivity()=" + getFlowDirectivity() + "]";
	}
	
	
	
	
}
