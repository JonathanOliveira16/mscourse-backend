package io.github.jonathan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.jonathan.controller.DTO.CourseDTO;
import io.github.jonathan.controller.DTO.ResponseCourseDTO;
import io.github.jonathan.exception.JsonBadFormattedException;
import io.github.jonathan.exception.NotFoundException;
import io.github.jonathan.service.CourseService;

@RestController
@RequestMapping("/v2/courses")
@CrossOrigin("http://localhost:4200")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/get-all")
	private List<ResponseCourseDTO> getAllCourses() throws NotFoundException {
		return courseService.getAllCourses();
	}
	
	@PutMapping("/update")
	private List<ResponseCourseDTO> updateCourse(@RequestBody CourseDTO course) throws NotFoundException, JsonBadFormattedException {
		return courseService.updateCourse(course);
	}
}
