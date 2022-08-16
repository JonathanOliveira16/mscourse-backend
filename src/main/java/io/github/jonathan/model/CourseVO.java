package io.github.jonathan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="COURSE")
public class CourseVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COURSEID")
	private Integer courseId;
	@Column(name="COURSENAME")
	private String courseName;
	@Column(name="COURSECATEGORY")
	private String courseCategory;
	@Column(name="COURSELEVEL")
	private String courseLevel;
	@ManyToOne
    @JoinColumn(name = "PERSONID")
	private PersonVO person;
	
}
