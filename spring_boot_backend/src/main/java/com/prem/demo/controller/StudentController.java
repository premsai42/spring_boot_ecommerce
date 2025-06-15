package com.prem.demo.controller;

import com.prem.demo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> s= new ArrayList<>(Arrays.asList(new Student(1,"prem"),new Student(2,"sai")));
@GetMapping("/student")
    public List<Student> getStudents()
{
    return s;
}
@PostMapping("/student")
    public Student addStudent(@RequestBody Student st)
{
    s.add(st);
    return st;
}
@GetMapping("/csrf")
    public CsrfToken getToken(HttpServletRequest s)
{
 return (CsrfToken) s.getAttribute("_csrf");
}
}
