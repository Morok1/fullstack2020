package com.fullstack2020.secondsem.controller;

import com.fullstack2020.secondsem.dao.CourseDao;
import com.fullstack2020.secondsem.dao.CourseJpaRepository;
import com.fullstack2020.secondsem.model.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3002"})
@RestController
public class CourseController {

    private final CourseJpaRepository courseRepository;
    private final CourseDao courseDao;

    public CourseController(CourseJpaRepository courseRepository, CourseDao courseDao) {
        this.courseRepository = courseRepository;
        this.courseDao = courseDao;
    }

    @GetMapping("/instructors/{username}/courses")
    public List<Course> getAllCourses(@PathVariable String username) {
        return courseRepository.findAll();
    }

    @GetMapping("/all-courses")
    public Collection<Course> getAllCoursesJdbc() {
        return courseDao.allCourses();
    }

    @GetMapping("/instructors/{username}/courses/{id}")
    public Course getCourse(@PathVariable String username, @PathVariable long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course Not Found with id " + id));
    }

    @DeleteMapping("/instructors/{username}/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String username, @PathVariable long id) {

        courseRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/instructors/{username}/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable String username,
                                               @PathVariable long id,
                                               @RequestBody Course course) {
        course.setUsername(username);
        Course courseUpdated = courseRepository.save(course);
        return new ResponseEntity<>(courseUpdated, HttpStatus.OK);
    }

    @PostMapping("/instructors/{username}/courses")
    public ResponseEntity<Void> createCourse(@PathVariable String username, @RequestBody Course course) {

        course.setUsername(username);

        Course createdCourse = courseRepository.save(course);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdCourse.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

}