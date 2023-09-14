package com.wipro.issue.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wipro.issue.model.Issue;


public interface IssueRepo extends CrudRepository<Issue, String> {
	
	List<Issue> findByid(String id);

}
