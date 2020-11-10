package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudentInfo(@RequestBody Student student){
        return studentService.addStudentInfo(student);
    }

    @GetMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentInfo(@PathVariable("id") AtomicInteger id){
        return studentService.getStudentInfo(id);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeStudentInfo(@PathVariable("id") AtomicInteger id){
        studentService.removeStudentInfo(id);
    }

    @PutMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudentInfo(@PathVariable("id") AtomicInteger id,
                                     @RequestBody Student student){
        return studentService.updateStudentInfo(id,student);
    }
}
