package Students.controlller;

import Students.model.Students;

import Students.repository.impl.StudentsRepsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsRepsImpl studentsReps;



    @GetMapping("/count")
    public int count(){
        return studentsReps.count();
    }

    @GetMapping("/findall")
    public List<Students> findAll(){
        return studentsReps.findAll();
    }
    @GetMapping("/findbyid/{id}")
    public Students findById(@PathVariable String id){
        if (studentsReps.findById(id) != null)
            return studentsReps.findById(id);
            return new Students("","","",0.0,"");
    }
    @GetMapping("/delete/{id}")
    public int delete(@PathVariable String id){
        return studentsReps.delete(id);
    }
}
