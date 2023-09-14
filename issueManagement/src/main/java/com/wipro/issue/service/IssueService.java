package com.wipro.issue.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.issue.model.Issue;
import com.wipro.issue.repository.IssueRepo;

@Service
public class IssueService {
	
	@Autowired
	IssueRepo issueRepo;
	
	
	public List<Issue> getAllIssue()
	{
		List<Issue> issue = new ArrayList();
		
		issueRepo.findAll().forEach(issue :: add);
		
		return issue;
	}
	
	public void addIssue(Issue issue)
	{
		issueRepo.save(issue);
	}
	
	public void updateIssue(String id , Issue issue)
	{
		Issue issue2 = this.findById(id).get(0);
		
		issue2.setDescription(issue.getDescription());
		issue2.setSeverity(issue.getSeverity());
		issue2.setStatus(issue.getStatus());
		
		issueRepo.save(issue2);
	}
	
	public void deleteIssue(String id)
	{
		issueRepo.deleteById(id);
	}
	
	public List<Issue> findById(String id)
	{
		
		return issueRepo.findByid(id);
		
	}

}
