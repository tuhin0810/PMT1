package com.example.demo.model;

public class ProcessTask {
	
	private long taskParentId;
	private String taskName;
	private String flowDirectivity;
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
	public String getFlowDirectivity() {
		return flowDirectivity;
	}
	public void setFlowDirectivity(String flowDirectivity) {
		this.flowDirectivity = flowDirectivity;
	}
	@Override
	public String toString() {
		return "ProcessTask [taskParentId=" + taskParentId + ", taskName=" + taskName + ", flowDirectivity="
				+ flowDirectivity + ", getTaskParentId()=" + getTaskParentId() + ", getTaskName()=" + getTaskName()
				+ ", getFlowDirectivity()=" + getFlowDirectivity() + "]";
	}
	
	
	
		
}
