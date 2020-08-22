package com.example.demo.entity;

public class ProcessTask {
	
	private long _taskParentId;
	private String _taskName;
	
	
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
	@Override
	public String toString() {
		return "ProcessTask [_taskParentId=" + _taskParentId + ", _taskName=" + _taskName + ", get_taskParentId()="
				+ get_taskParentId() + ", get_taskName()=" + get_taskName() + "]";
	}
		
	
}
