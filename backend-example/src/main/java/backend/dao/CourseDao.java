package com.fullstack2020.secondsem.dao;

import com.fullstack2020.secondsem.model.Course;

import java.util.Collection;

public interface CourseDao {
    Collection<Course> allCourses();

    Course courseByName(String name);
}
