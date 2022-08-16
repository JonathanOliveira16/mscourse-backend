package io.github.jonathan.controller.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseDTO {
	@JsonProperty("courseId")
	private Integer cId;
	@JsonProperty("courseCategory")
	private String cCategory;
	@JsonProperty("courseLevel")
	private String cLevel;
	@JsonProperty("coordinator")
	private Integer corNew;
	
}
