package io.github.jonathan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.jonathan.model.CourseVO;

@Repository
public interface CourseRepository extends JpaRepository<CourseVO, Integer>{
	
	@Query(value="select * from COURSE", nativeQuery=true)
	public List<CourseVO> getList();
	
}
