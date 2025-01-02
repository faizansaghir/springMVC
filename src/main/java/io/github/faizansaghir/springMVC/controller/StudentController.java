package io.github.faizansaghir.springMVC.controller;

import io.github.faizansaghir.springMVC.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {

        Student student = new Student();

        model.addAttribute("bindingStudentObject", student);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("bindingStudentObject") Student student) {

        System.out.println("Student: "+student.getFirstName()+" "+student.getLastName());

        return "student-confirmation";
    }

}
