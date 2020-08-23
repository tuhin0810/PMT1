package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CaseDTO;
import com.example.demo.entity.CounterDTO;
import com.example.demo.entity.Employee;
import com.example.demo.entity.ProcessDTO;
import com.example.demo.entity.TaskDTO;
import com.example.demo.model.CaseRequest;
import com.example.demo.model.CaseResponse;
import com.example.demo.model.Process;
import com.example.demo.model.ProcessTask;
import com.example.demo.model.Task;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	MongoTemplate mongoTemplate;
	
	
	@Override
	public List<Employee> getEmployee() {
		return mongoTemplate.findAll(Employee.class);
		
	}


	@Override
	public void createProcess(Process process) {
		ProcessDTO processDTO = new ProcessDTO();
		processDTO.set_processId(getSequence("Process_Collection"));
		processDTO.set_processName(process.getProcessName());
		processDTO.set_processOwner(process.getProcessOwner());
		processDTO.set_processTask(process.getProcessTask());
		mongoTemplate.save(processDTO);
	}
	
	
	
	private int getSequence(String CollectionName) {
		 Query query = new Query();
		 query.addCriteria(Criteria.where("_userId").is(CollectionName));
		 Update update = new Update().inc("_seq", 1);
		 return mongoTemplate.findAndModify(query, update,new FindAndModifyOptions().returnNew(true), CounterDTO.class, "Counter").get_seq();
	}


	@Override
	public void createCase(CaseRequest bpmCase) {
		int caseId = getSequence("Case_Collection");
		 Query queryProcess = new Query();
		 System.out.println("************bpm********"+bpmCase.getProcessId());
		 queryProcess.addCriteria(Criteria.where("_processId").is(bpmCase.getProcessId()));
		List<ProcessTask> tasks = mongoTemplate.findOne(queryProcess, ProcessDTO.class).get_processTask();
		
		List<TaskDTO> taskDTOs = new ArrayList<>();
		tasks.stream().forEach((task) -> {
			TaskDTO taskDTO = new TaskDTO();
			if(taskDTOs.size() == 0) {
				taskDTO.set_taskStatus("ACTIVE");
			} else {
			taskDTO.set_taskStatus("OPEN");
			}
			taskDTO.set_taskName(task.getTaskName());
			taskDTO.set_taskParentId(task.getTaskParentId());
			taskDTO.set_caseId(caseId);
			taskDTO.set_creationTime(bpmCase.getCaseCreationDate());
			taskDTO.set_completionTime(bpmCase.getCaseCreationDate());
			taskDTO.set_flowDirectivity(task.getFlowDirectivity());
			taskDTO.set_processId(bpmCase.getProcessId());
			taskDTOs.add(taskDTO);
			
		});
		mongoTemplate.insertAll(taskDTOs);
		CaseDTO caseDTO = new CaseDTO();
		
		caseDTO.set_caseStatus("OPEN");
		caseDTO.set_caseCreationDate(bpmCase.getCaseCreationDate());
		caseDTO.set_caseId(caseId);
		caseDTO.set_caseName(bpmCase.getCaseName());
		caseDTO.set_processId(bpmCase.getProcessId());
		caseDTO.set_processOwner(bpmCase.getProcessOwner());
		List<TaskDTO> taskDTOFiltered = taskDTOs.stream()
		.filter( f -> f.get_taskStatus().equalsIgnoreCase("ACTIVE"))
				.collect(Collectors.toList());
		caseDTO.set_taskList(taskDTOFiltered);
		mongoTemplate.save(caseDTO);
	}


	@Override
	public List<CaseResponse> getCaseByUser(String processOwner) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_processOwner").is(processOwner));
		List<CaseDTO> caseDTOs = mongoTemplate.find(query,CaseDTO.class);
		List<CaseResponse> cases = new ArrayList<>();
		caseDTOs.stream().forEach(caseComponent -> {
			CaseResponse caseModel =  new CaseResponse();
			caseModel.setCaseCreationDate(caseComponent.get_caseCreationDate());
			caseModel.setCaseName(caseComponent.get_caseName());
			caseModel.setCaseId(caseComponent.get_caseId());
			caseModel.setProcessId(caseComponent.get_processId());
			caseModel.setProcessOwner(caseComponent.get_processOwner());
			if(0 < caseComponent.get_taskList().size()) {
				List<Task> tasks = new ArrayList<>();
				List<TaskDTO> taskDTOs = caseComponent.get_taskList();
				System.out.println("*******TaskList******"+taskDTOs.toString());
				taskDTOs.stream()
				.filter( f -> f.get_taskStatus().equalsIgnoreCase("ACTIVE")).collect(Collectors.toList())
				.forEach(taskDTO -> {
					Task activeTask = new Task();
					activeTask.setCaseId(taskDTO.get_caseId());
					activeTask.setCompletionTime(taskDTO.get_completionTime());
					activeTask.setCreationTime(taskDTO.get_creationTime());
					activeTask.setProcesId(taskDTO.get_processId());
					activeTask.setTaskName(taskDTO.get_taskName());
					activeTask.setTaskParentId(taskDTO.get_taskParentId());
					activeTask.setTaskStatus(taskDTO.get_taskStatus());
					tasks.add(activeTask);
				});
			caseModel.setTaskList(tasks);
			}
			cases.add(caseModel);
		});
		return cases;
	}


	@Override
	public Task completeActiveTask(long processId, long caseId, long taskParentId) {
		Query queryActiveTask = new Query();
		queryActiveTask = queryActiveTask.addCriteria(new Criteria().andOperator(Criteria.where("_processId").is(processId),
				Criteria.where("_caseId").is(caseId),Criteria.where("_taskStatus").is("ACTIVE"),
				Criteria.where("_taskParentId").is(taskParentId)));
		
		List <TaskDTO> t =mongoTemplate.find( new Query().addCriteria(new Criteria().andOperator(Criteria.where("_processId").is(processId),
				Criteria.where("_caseId").is(caseId))),TaskDTO.class);
		System.out.println("=========db response============"+t.toString());
		
		Update update = new Update().set("_taskStatus", "COMPLETED");
		
		mongoTemplate.findAndModify(queryActiveTask, update, new FindAndModifyOptions().returnNew(true), TaskDTO.class);
		
		Query queryCompletedTask = new Query();
		
		queryCompletedTask = queryCompletedTask.addCriteria(new Criteria().andOperator(Criteria.where("_processId").is(processId),
				Criteria.where("_caseId").is(caseId),Criteria.where("_taskParentId").gt(taskParentId)));
		
		TaskDTO taskDTO = mongoTemplate.findAndModify(queryCompletedTask, 
				new Update().set("_taskStatus", "ACTIVE"), 
				new FindAndModifyOptions().returnNew(true), 
				TaskDTO.class);
		
		Query caseQuery = new Query();
		caseQuery.addCriteria(new Criteria().andOperator(Criteria.where("_processId").is(processId),
				Criteria.where("_caseId").is(caseId),Criteria.where("_taskList._taskStatus").is("ACTIVE")));
		
		Query casePushQuery =  new Query();
		casePushQuery.addCriteria(new Criteria().andOperator(Criteria.where("_processId").is(processId),
				Criteria.where("_caseId").is(caseId)));
		
		mongoTemplate.findAndModify(caseQuery,new Update().set("_taskList.$._taskStatus", "COMPLETED"),CaseDTO.class);
		mongoTemplate.findAndModify(casePushQuery,new Update().push("_taskList", taskDTO),CaseDTO.class);
		Task activeTask = new Task();
		activeTask.setCaseId(taskDTO.get_caseId());
		activeTask.setCompletionTime(taskDTO.get_completionTime());
		activeTask.setCreationTime(taskDTO.get_creationTime());
		activeTask.setProcesId(taskDTO.get_processId());
		activeTask.setTaskName(taskDTO.get_taskName());
		activeTask.setTaskParentId(taskDTO.get_taskParentId());
		activeTask.setTaskStatus(taskDTO.get_taskStatus());
		return activeTask;
	}


	@Override
	public List<Task> retrieveCompletedTask(long processId, long caseId) {
		Query query = new Query();
		query.addCriteria(new Criteria().andOperator(Criteria.where("_processId").is(processId),Criteria.where("_caseId").is(caseId)));
		List<TaskDTO> taskDTOs = mongoTemplate.find(query,TaskDTO.class);
		List<Task> tasks = new ArrayList<>();
		taskDTOs.stream()
		.filter( f -> f.get_taskStatus().equalsIgnoreCase("COMPLETED")).collect(Collectors.toList())
		.forEach(taskDTO -> {
			Task compltedTask = new Task();
			compltedTask.setCaseId(taskDTO.get_caseId());
			compltedTask.setCompletionTime(taskDTO.get_completionTime());
			compltedTask.setCreationTime(taskDTO.get_creationTime());
			compltedTask.setProcesId(taskDTO.get_processId());
			compltedTask.setTaskName(taskDTO.get_taskName());
			compltedTask.setTaskParentId(taskDTO.get_taskParentId());
			compltedTask.setTaskStatus(taskDTO.get_taskStatus());
			tasks.add(compltedTask);
		});
		return tasks;
	}
	
	
	
	
	
	
	

}
