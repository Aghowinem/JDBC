package Students.repository.impl;

import Students.mapper.studentsMapper;
import Students.model.Students;

import org.apache.catalina.valves.JDBCAccessLogValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentsRepsImpl  {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int count() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM students", Integer.class);
    }


    public List<Students> findAll() {
        return jdbcTemplate.query("SELECT * FROM students", new studentsMapper());
    }


    public Students findById(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM students WHERE id = ?", new Object[]{id}, new studentsMapper());
    }


    public int insert(Students students) {
        return jdbcTemplate.update("INSERT INTO students (id, name, major, gpa, gender) VALUES (?, ?, ?, ?, ?)",
                new Object[]{students.getId(),students.getName(),students.getMajor(),students.getGpa(),students.getGender()});
    }

    public int update(Students students) {
        return jdbcTemplate.update("UPDATE students SET name = ?, major = ?, gpa = ?, gender = ?",
                new Object[]{students.getName(),students.getMajor(),students.getGpa(),students.getGender(),students.getId()});
    }


    public int delete(String id) {
        return jdbcTemplate.update("DELETE FROM students WHERE id = ?", new Object[]{id});
    }
}
