package com.ust.spring.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private Date startingDate;
	private Date endingDate;
//	@OneToMany(mappedBy = "project")
//	private List<User> users;
//	@OneToMany(mappedBy = "project")
//	private List<Task> tasks;
	
	@ManyToMany(mappedBy = "assignedProjects")
    private List<User> users;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;
}
 