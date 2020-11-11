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

    public Student save(Student student) {
        AtomicInteger newId = new AtomicInteger();
        if(studentList.size()>0){
            newId.set(studentList.get(studentList.size()-1).getId().get()+1);
        }else{
            newId.set(1);
        }
        student.setId(newId);
        studentList.add(student);
        return student;
    }

    public Student findById(AtomicInteger id) throws Exception {
        List<Student> findStudent = studentList.stream()
                .filter(student -> student.getId().get() == (id.get()))
                .collect(Collectors.toList());
        if (findStudent.size() == 0) {
            throw new Exception();
        }
        return findStudent.get(0);
    }

    public void removeById(AtomicInteger id) throws Exception {
        Student student = findById(id);
        studentList.remove(student);
    }

    public Student updateById(AtomicInteger id, Student student) throws Exception {
        removeById(id);
        student.setId(id);
        return save(student);
    }
}
