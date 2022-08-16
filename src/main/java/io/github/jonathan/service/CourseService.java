package io.github.jonathan.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jonathan.controller.DTO.CourseDTO;
import io.github.jonathan.controller.DTO.ResponseCourseDTO;
import io.github.jonathan.exception.JsonBadFormattedException;
import io.github.jonathan.exception.NotFoundException;
import io.github.jonathan.model.CourseVO;
import io.github.jonathan.model.PersonVO;
import io.github.jonathan.repository.CourseRepository;
import io.github.jonathan.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourseService {

	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private PersonRepository persoRepo;

	public List<ResponseCourseDTO> getAllCourses() throws NotFoundException{
		List<ResponseCourseDTO> listResponse = new ArrayList<>();
		List<CourseVO> listCourses = courseRepo.findAll();
		log.info(Arrays.toString(listCourses.toArray()));
		listCourses.stream().forEach(x ->{
			ResponseCourseDTO res = new ResponseCourseDTO(x.getCourseId(), x.getCourseName(), x.getCourseCategory(),
					x.getCourseLevel(), x.getPerson().getFirstName(), x.getPerson().getEmail());
			listResponse.add(res);
		});
		if(listResponse.size() == 0) {
			throw new NotFoundException("No data in database!");
		}
		return listResponse;
	}
	
	@Transactional
	public List<ResponseCourseDTO> updateCourse(CourseDTO c) throws NotFoundException, JsonBadFormattedException {
		if(c.equals(null) || c.getCId() == null) {
			throw new JsonBadFormattedException("Bad formatted JSON");
		}
		Optional<CourseVO> courseDb = courseRepo.findById(c.getCId());
		if(courseDb.isPresent()) {
			log.info(c.toString());
			if(c.getCCategory() != null) {
				courseDb.get().setCourseCategory(c.getCCategory());
			}
			if(c.getCLevel() != null) {
				courseDb.get().setCourseLevel(c.getCLevel());
			}
			if(c.getCorNew() != null) {
				courseDb.get().setPerson(persoRepo.findById(c.getCorNew()).get());
			}
			courseRepo.save(courseDb.get());
			return getAllCourses();
		}else {
			throw new NotFoundException();
		}
	}
}
