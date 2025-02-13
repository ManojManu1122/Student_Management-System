package com.example.student.management.system.Service;

import com.example.student.management.system.Model.Student;
import com.example.student.management.system.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentService {
    @Autowired
    private StudentRepo repo;

    public List<Student> getAllStudents() {
        List<Student> students = repo.findAll();
        return students;
    }

    public Student addStudent(Student student) {
        return repo.save(student);


    }

    public Student getStudentById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void updateStudent(int id, Student student) {
        Student std = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        std.setFirstName(student.getFirstName());
        std.setLastName(student.getLastName());
        std.setEmail(student.getEmail());

        repo.save(std);

    }

    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
}
