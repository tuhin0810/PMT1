package com.example.demo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Counter")
public class CounterDTO {
	
	@Id
	private ObjectId _id;
	private String _userId;
	private int _seq;
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String get_userId() {
		return _userId;
	}
	public void set_userId(String _userId) {
		this._userId = _userId;
	}
	public int get_seq() {
		return _seq;
	}
	public void set_seq(int _seq) {
		this._seq = _seq;
	}
	
	@Override
	public String toString() {
		return "CounterDTO [_id=" + _id + ", _userId=" + _userId + ", _seq=" + _seq + ", get_id()=" + get_id()
				+ ", get_userId()=" + get_userId() + ", get_seq()=" + get_seq() + "]";
	}
}
