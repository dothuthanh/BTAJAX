package ajax.controller;

import ajax.model.Student;
import ajax.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("student/index");
        modelAndView.addObject("list", studentService.findAll());
        return modelAndView;
    }
        @GetMapping()
                public ResponseEntity<Iterable<Student>> getAll(){
            return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
        }
        @PostMapping("/")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
        }
        @PutMapping("/{id")
    public ResponseEntity<Student> edit(@PathVariable Long id , @RequestBody Student student) {
        student.setId(id);
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
        }
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id){
        studentService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/demo")
    public ResponseEntity<Student> demo(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    }
