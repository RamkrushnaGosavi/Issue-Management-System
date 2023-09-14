package com.wipro.issue.model;


import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table
public class Issue {
	
	
	@Id
	@Column
	private String id = "issue"+Math.random();
	
	@Column
	private String description , severity , status;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Issue [id=" + id + ", description=" + description + ", severity=" + severity + ", status=" + status
				+ "]";
	}

}
