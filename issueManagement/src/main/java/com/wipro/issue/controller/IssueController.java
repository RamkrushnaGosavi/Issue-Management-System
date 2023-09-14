package com.wipro.issue.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.issue.model.Issue;
import com.wipro.issue.service.IssueService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class IssueController {
	
	@Autowired
	IssueService issueService;
	
	@GetMapping("/")
	public String defaultMethod()
	{
		return "Welcome";
	}
	
	@GetMapping("/getIssue")
	public List<Issue> getIssue()
	{
		return issueService.getAllIssue();
	}
	
	@PostMapping("/addIssue")
	public void addIssue(@RequestBody Issue issue)
	{
		issueService.addIssue(issue);
	}
	
	@PutMapping("/updateIssue/{id}")
	public void updateIssue(@PathVariable("id") String id ,@RequestBody Issue issue)
	{
		issueService.updateIssue(id, issue);
	}
	
	@DeleteMapping("/deleteIssue/{id}")
	public void deleteIssue(@PathVariable("id") String id)
	{
		issueService.deleteIssue(id);
	}
	
	@ResponseBody 
	@GetMapping("/{id}")
	public Issue findById(@PathVariable("id") String id)
	{
		
		return issueService.findById(id).get(0);
		
	}

}
