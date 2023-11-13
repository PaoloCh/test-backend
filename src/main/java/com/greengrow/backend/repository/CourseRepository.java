package com.greengrow.backend.repository;

import com.greengrow.backend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Boolean existsByNameAndPrice(String name, String price);
}
