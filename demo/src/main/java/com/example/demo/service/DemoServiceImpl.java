package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	MongoTemplate mongoTemplate;
	
	
	@Override
	public List<Employee> getEmployee() {
		return mongoTemplate.findAll(Employee.class);
		
	}

}
