package io.github.jonathan.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.jonathan.controller.DTO.CourseDTO;
import io.github.jonathan.exception.JsonBadFormattedException;
import io.github.jonathan.exception.NotFoundException;
import io.github.jonathan.model.CourseVO;
import io.github.jonathan.repository.CourseRepository;
import io.github.jonathan.service.builders.CourseBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {

	@InjectMocks
	CourseService courseService;

	private AutoCloseable closeable;

	@Autowired
	private CourseRepository courseRepository;

	@Before
	public void setup() {
		closeable = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	void closeService() throws Exception {
		closeable.close();
	}

	@Test
	public void shouldThrowJsonError() throws NotFoundException {
		CourseDTO dto = CourseBuilder.onceCourse().withNullValues().now();
		try {
			courseService.updateCourse(dto);
		} catch (JsonBadFormattedException e) {
			Assert.assertEquals(e.getMessage(), "Bad formatted JSON");
		}
	}

	@Test
	public void saveTest() {
		CourseDTO dto = CourseBuilder.onceCourse().now();
		CourseVO c = new CourseVO();
		c.setCourseCategory(dto.getCCategory());
		c.setCourseId(dto.getCId());
		c.setCourseLevel(dto.getCLevel());
		c.setCourseName("teste");
		c.setPerson(null);
		courseRepository.save(c);
		Assert.assertNotNull(courseRepository.findById(1));
	}
}
