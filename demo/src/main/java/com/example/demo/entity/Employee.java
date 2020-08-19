
package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sample_test")
public class Employee {

	@Id
	private String _id;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String get_EmpName() {
		return _EmpName;
	}

	public void set_EmpName(String _EmpName) {
		this._EmpName = _EmpName;
	}

	String _EmpName;

	String Address;

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) { Address = address; }

	// getter, setter, toString, Constructors

}