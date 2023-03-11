package Students.mapper;

import Students.model.Students;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class studentsMapper implements RowMapper<Students> {

    @Override
    public Students mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Students(rs.getString("id"),rs.getString("name"),rs.getString("major"),rs.getDouble("gpa"), rs.getNString("gender"));
    }
}
