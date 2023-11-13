package com.greengrow.backend.service.impl;

import com.greengrow.backend.model.Course;
import com.greengrow.backend.repository.CourseRepository;
import com.greengrow.backend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course){
        return courseRepository.save(course);
    }
}
