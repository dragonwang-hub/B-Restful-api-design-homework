package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.getStudentList();
    }

    public Student addStudent(Student student) {
        List<Student> studentList = studentRepository.getStudentList();
        studentList.add(student);
        studentRepository.setStudentList(studentList);
        return student;
    }

    public Student getStudentInfo(AtomicInteger id) {
        return studentRepository.findByID(id);
    }
}
