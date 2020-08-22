package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Task_Collection")
public class taskDTO {
	
	private long _procesId;
	private long _caseId;
	private long _taskParentId;
	private String _taskName;
	private long _creationTime;
	private long _completionTime;
	private long _flowDirectivity;
	
	@Id
	public long get_procesId() {
		return _procesId;
	}
	public void set_procesId(long _procesId) {
		this._procesId = _procesId;
	}
	public long get_caseId() {
		return _caseId;
	}
	public void set_caseId(long _caseId) {
		this._caseId = _caseId;
	}
	public long get_taskParentId() {
		return _taskParentId;
	}
	public void set_taskParentId(long _taskParentId) {
		this._taskParentId = _taskParentId;
	}
	public String get_taskName() {
		return _taskName;
	}
	public void set_taskName(String _taskName) {
		this._taskName = _taskName;
	}
	public long get_creationTime() {
		return _creationTime;
	}
	public void set_creationTime(long _creationTime) {
		this._creationTime = _creationTime;
	}
	public long get_completionTime() {
		return _completionTime;
	}
	public void set_completionTime(long _completionTime) {
		this._completionTime = _completionTime;
	}
	public long get_flowDirectivity() {
		return _flowDirectivity;
	}
	public void set_flowDirectivity(long _flowDirectivity) {
		this._flowDirectivity = _flowDirectivity;
	}
	@Override
	public String toString() {
		return "taskDTO [_procesId=" + _procesId + ", _caseId=" + _caseId + ", _taskParentId=" + _taskParentId
				+ ", _taskName=" + _taskName + ", _creationTime=" + _creationTime + ", _completionTime="
				+ _completionTime + ", _flowDirectivity=" + _flowDirectivity + ", get_procesId()=" + get_procesId()
				+ ", get_caseId()=" + get_caseId() + ", get_taskParentId()=" + get_taskParentId() + ", get_taskName()="
				+ get_taskName() + ", get_creationTime()=" + get_creationTime() + ", get_completionTime()="
				+ get_completionTime() + ", get_flowDirectivity()=" + get_flowDirectivity() + "]";
	}
	
}
