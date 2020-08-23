package com.example.demo.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Case_Collection")
public class CaseDTO {
	
	@Id
	private ObjectId _id;
	private long _processId;
	private long _caseId;
	private long _caseCreationDate;
	private String _processOwner;
	private List<TaskDTO> _taskList;
	private String _caseStatus;
	private String _caseName;
	
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
	public long get_caseId() {
		return _caseId;
	}
	public void set_caseId(long _caseId) {
		this._caseId = _caseId;
	}
	public long get_caseCreationDate() {
		return _caseCreationDate;
	}
	public void set_caseCreationDate(long _caseCreationDate) {
		this._caseCreationDate = _caseCreationDate;
	}
	public String get_processOwner() {
		return _processOwner;
	}
	public void set_processOwner(String _processOwner) {
		this._processOwner = _processOwner;
	}
	public List<TaskDTO> get_taskList() {
		return _taskList;
	}
	public void set_taskList(List<TaskDTO> _taskList) {
		this._taskList = _taskList;
	}
	
	
	public String get_caseStatus() {
		return _caseStatus;
	}
	public void set_caseStatus(String _caseStatus) {
		this._caseStatus = _caseStatus;
	}
	
	public String get_caseName() {
		return _caseName;
	}
	public void set_caseName(String _caseName) {
		this._caseName = _caseName;
	}
	
	@Override
	public String toString() {
		return "CaseDTO [_processId=" + _processId + ", _caseId=" + _caseId + ", _caseCreationDate=" + _caseCreationDate
				+ ", _processOwner=" + _processOwner + ", _taskList=" + _taskList + ", get_processId()="
				+ get_processId() + ", get_caseId()=" + get_caseId() + ", get_caseCreationDate()="
				+ get_caseCreationDate() + ", get_processOwner()=" + get_processOwner() + ", get_taskList()="
				+ get_taskList() + "]";
	}
	
	
}
