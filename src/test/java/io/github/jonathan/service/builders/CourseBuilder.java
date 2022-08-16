package io.github.jonathan.service.builders;

import io.github.jonathan.controller.DTO.CourseDTO;

public class CourseBuilder {

	private CourseDTO course;
	
	private CourseBuilder() {}
	
	public static CourseBuilder onceCourse() {
		CourseBuilder builder = new CourseBuilder();
		builder.course = new CourseDTO();
		builder.course.setCId(1);
		builder.course.setCLevel("basic");
		builder.course.setCCategory("I.T");
		builder.course.setCorNew(2);
		return builder;
	}
	
	public CourseDTO now() {
		return course;
	}
	
	public CourseBuilder withNullValues() {
		course.setCId(null);
		return this;
	}
}
