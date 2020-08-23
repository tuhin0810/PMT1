package com.example.demo.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.ProcessTask;

@Document(collection = "Process_Collection")
public class ProcessDTO {

	@Id
	private ObjectId _id;
	private long _processId;
	private String _processOwner;
	private String _processName;
	private List<ProcessTask> _processTask;
	
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public long get_processId() {
		return _processId;
	}
	public void set_processId(long _processId) {
		this._processId = _processId;
	}
	public String get_processOwner() {
		return _processOwner;
	}
	public void set_processOwner(String _processOwner) {
		this._processOwner = _processOwner;
	}
	public String get_processName() {
		return _processName;
	}
	public void set_processName(String _processName) {
		this._processName = _processName;
	}
	public List<ProcessTask> get_processTask() {
		return _processTask;
	}
	public void set_processTask(List<ProcessTask> _processTask) {
		this._processTask = _processTask;
	}
	@Override
	public String toString() {
		return "ProcessDTO [_processId=" + _processId + ", _processOwner=" + _processOwner + ", _processName="
				+ _processName + ", _processTask=" + _processTask + ", get_processId()=" + get_processId()
				+ ", get_processOwner()=" + get_processOwner() + ", get_processName()=" + get_processName()
				+ ", get_processTask()=" + get_processTask() + "]";
	}

	
	
}
