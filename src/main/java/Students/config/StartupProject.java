package Students.config;


import Students.model.Students;

import Students.repository.impl.StudentsRepsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StartupProject implements CommandLineRunner {

    @Autowired
    private StudentsRepsImpl studentsRepsImpl;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {

        jdbcTemplate.execute("DROP TABLE IF exists students");
        jdbcTemplate.execute("CREATE TABLE students(id VARCHAR(255), name VARCHAR(255), major VARCHAR(255), gpa double , gender VARCHAR(255))");

        if(studentsRepsImpl.count() == 0){

            studentsRepsImpl.insert(new Students("106","Khalid","SWE",2.33,"M"));
            studentsRepsImpl.insert(new Students("107","Mohammed","CS",4.64,"M"));
            studentsRepsImpl.insert(new Students("108","Norah","IS",2.33,"F"));
            studentsRepsImpl.insert(new Students("109","Saad","CS",4.21,"M"));

        }


    }
}
