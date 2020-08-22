package com.example.demo.model;

import java.util.List;



public class Process {

	private long processId;
	private String processOwner;
	private String processName;
	private List<ProcessTask> processTask;
	public long getProcessId() {
		return processId;
	}
	public void setProcessId(long processId) {
		this.processId = processId;
	}
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
	@Override
	public String toString() {
		return "Process [processId=" + processId + ", processOwner=" + processOwner + ", processName=" + processName
				+ ", processTask=" + processTask + ", getProcessId()=" + getProcessId() + ", getProcessOwner()="
				+ getProcessOwner() + ", getProcessName()=" + getProcessName() + ", getProcessTask()="
				+ getProcessTask() + "]";
	}
	
	
	
}
