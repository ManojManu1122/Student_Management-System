package com.example.student.management.system.Controller;

import com.example.student.management.system.Model.Student;
import com.example.student.management.system.Model.User;
import com.example.student.management.system.Repository.StudentRepo;
import com.example.student.management.system.Repository.UserRepository;
import com.example.student.management.system.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentRepo studentRepo;




    @GetMapping("/allStudents")
    public String getAllStudents(Model model, Principal principal) {
        List<Student> students = service.getAllStudents();
        Optional<User> optionalUser = userRepository.findByEmail(principal.getName());

        if (optionalUser.isPresent()) {
            model.addAttribute("loggedInUser", optionalUser.get());
        }

        model.addAttribute("students", students);
        return "students";
    }


    @GetMapping("/students/new")
    public String showNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "create_student";
    }
//    @PostMapping("/students/new")
//    public String addStudent(@ModelAttribute Student student){
//       service.addStudent(student);
//       return "redirect:/allStudents";
//
//    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable int id,Model model){
        Student student = service.getStudentById(id);
        model.addAttribute("student",student);
        return "edit_student";
    }

    @PostMapping("/students/update/{id}")
    public String updateStudent(@PathVariable int id,@ModelAttribute Student student){
        service.updateStudent(id,student);
        return "redirect:/allStudents";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id, Principal principal) {
        Student student = studentRepo.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("Student not found"));
        if (!student.getUser().getEmail().equals(principal.getName())) {
            return "redirect:/allStudents/my"; // Prevent unauthorized deletion
        }
        studentRepo.delete(student);
        return "redirect:/allStudents/my";
    }


    @GetMapping("/allStudents/my")
    public String getMyStudents(Model model, Principal principal) {
        Optional<User> optionalUser = userRepository.findByEmail(principal.getName());

        List<Student> students = studentRepo.findByUser(optionalUser);

        model.addAttribute("students", students);
        model.addAttribute("loggedInUser", optionalUser.orElse(null));

        return "students";
    }



    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute("student") Student student, Principal principal) {
        Optional<User> optionalUser = userRepository.findByEmail(principal.getName());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            student.setUser(user);
            studentRepo.save(student);
            return "redirect:/allStudents/my";
        } else {

            return "redirect:/error";
        }
    }

    @GetMapping("/students/view/{id}")
    public String viewStudent(@PathVariable int id, Model model) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        model.addAttribute("student", student);
        return "view_student";
    }



}
