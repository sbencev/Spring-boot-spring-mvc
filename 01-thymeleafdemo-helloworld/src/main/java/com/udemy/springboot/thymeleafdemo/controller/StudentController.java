package com.udemy.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.udemy.springboot.thymeleafdemo.model.Student;

@Controller
public class StudentController {

	@Value("${countries}")
	private List<String> countries;

	@Value("${systems}")
	private List<String> systems;

	@Value("${languages}")
	private List<String> languages;

	@GetMapping("/showStudentForm")
	public String showForm(Model theModel) {

		Student theStudent = new Student();

		theModel.addAttribute("student", theStudent);

		theModel.addAttribute("countries", countries);

		theModel.addAttribute("languages", languages);

		theModel.addAttribute("systems", systems);

		return "student-form";

	}

	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {

		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

		return "student-confirmation";

	}

}
