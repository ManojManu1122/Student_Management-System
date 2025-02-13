package com.example.student.management.system.Repository;

import com.example.student.management.system.Model.Student;
import com.example.student.management.system.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    List<Student> findByUser(Optional<User> user);

}
