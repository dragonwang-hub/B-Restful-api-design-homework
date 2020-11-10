package com.thoughtworks.capability.gtb.restfulapidesign.Repository;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    List<Student> studentList = new ArrayList<>();

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public Student findById(AtomicInteger id) {
        return studentList.stream().filter(student -> student.getId().equals(id)).collect(Collectors.toList()).get(0);
    }

    public void removeById(AtomicInteger id) {
        studentList.remove(id);
    }
}
