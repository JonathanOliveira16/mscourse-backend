package io.github.jonathan.controller.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCourseDTO {
	@JsonProperty("courseId")
	private Integer cId;
	@JsonProperty("courseName")
	private String cName;
	@JsonProperty("courseCategory")
	private String cCategory;
	@JsonProperty("courseLevel")
	private String cLevel;
	@JsonProperty("coordinatorName")
	private String corName;
	@JsonProperty("coordinatorEmail")
	private String corEmail;
}
