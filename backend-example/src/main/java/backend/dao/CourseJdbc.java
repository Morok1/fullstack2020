package com.fullstack2020.secondsem.dao;

import com.fullstack2020.secondsem.model.Course;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CourseJdbc implements CourseDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Course> allCourses() {

        return jdbcTemplate.query("select * from course", (rs, i) -> new Course(
                rs.getLong("ID"),
                rs.getString("USERNAME"),
                rs.getString("DESCRIPTION")));
    }

    @Override
    public Course courseByName(String name) {
        return null;
    }
}
