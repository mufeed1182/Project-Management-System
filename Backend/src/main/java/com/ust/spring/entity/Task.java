package com.ust.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String taskName;
	private String status;
	
	@ManyToOne
    @JoinColumn(name = "project_id")
	@JsonIgnore
    private Project project;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    @JsonIgnore
    private User assignedUser;
}
