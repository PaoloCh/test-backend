package com.greengrow.backend.controller;

import com.greengrow.backend.repository.CourseRepository;
import com.greengrow.backend.model.Course;
import com.greengrow.backend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/green-grow/v1")
public class CourseController {
    @Autowired
    private CourseService courseService;

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    //URL: http://localhost:8080/api/green-grow/v1/courses
    //Method: GET
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<List<Course>>(courseRepository.findAll(), HttpStatus.OK);
    }

    //GetById
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(Long id) {
        return new ResponseEntity<Course>(courseRepository.findById(id).get(), HttpStatus.OK);
    }

    //PENDIENTE: Agregar filterBy(algo)
    //Filter by category + ofrecer al crear en el front

    //URL: http://localhost:8080/api/green-grow/v1/courses
    //Method: POST
    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        try {
            validateCourse(course);
            //existsByNameAndPrice(course);
            return new ResponseEntity<Course>(courseService.createCourse(course), HttpStatus.CREATED);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Validaciones
    private void validateCourse(Course course){
        if(course.getName() == null || course.getName().isEmpty()){
            throw new RuntimeException("El nombre del curso es obligatorio");
        }

        if(course.getName().length() > 150){
            throw new RuntimeException("El nombre del curso no puede tener más de 50 caracteres");
        }

        if(course.getImage() == null || course.getImage().isEmpty()){
            throw new RuntimeException("El enlace de la imagen del curso es obligatoria");
        }

        if(course.getImage().length() > 200){
            throw new RuntimeException("El enlace de la imagen del curso no puede tener más de 200 caracteres");
        }

        if(course.getDescription() == null || course.getDescription().isEmpty()){
            throw new RuntimeException("La descripción del curso es obligatoria");
        }

        if(course.getDescription().length() > 150){
            throw new RuntimeException("La descripción del curso no puede tener más de 100 caracteres");
        }

        if(course.getPrice() == null || course.getPrice().isEmpty()){
            throw new RuntimeException("El precio del curso es obligatorio");
        }

        if(course.getPrice().length() > 6){
            throw new RuntimeException("El precio del curso no puede tener más de 6 caracteres");
        }

        if(course.getRating() == null || course.getRating().isEmpty()){
            throw new RuntimeException("El rating del curso es obligatorio");
        }

        if(course.getRating().length() > 3){
            throw new RuntimeException("El rating del curso no puede tener más de 3 caracteres");
        }

        if(course.getDuration() == null || course.getDuration().isEmpty()){
            throw new RuntimeException("La duración del curso es obligatoria");
        }

        if(course.getDuration().length() > 3) {
            throw new RuntimeException("La duración del curso no puede tener más de 3 caracteres");
        }

        if(course.getCategory() == null || course.getCategory().isEmpty()){
            throw new RuntimeException("La categoría del curso es obligatoria");
        }

        if(course.getCategory().length() > 150){
            throw new RuntimeException("La categoría del curso no puede tener más de 150 caracteres");
        }

        if(course.getDate() == null || course.getDate().isEmpty()){
            throw new RuntimeException("La fecha del curso es obligatoria");
        }

        if(course.getDate().length() > 30){
            throw new RuntimeException("La fecha del curso no puede tener más de 30 caracteres");
        }


    }

    /*
    private void existsByNameAndPrice(Course course){
        if(courseRepository.existsByNameAndPrice(course.getName(), course.getPrice())){
            throw new RuntimeException("Ya existe un curso con el mismo nombre y precio");
        }
    }
    */
}