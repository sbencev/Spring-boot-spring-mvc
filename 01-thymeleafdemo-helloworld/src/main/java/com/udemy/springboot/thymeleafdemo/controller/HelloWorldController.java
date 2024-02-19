package com.udemy.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

	@GetMapping("/showForm")
	public String showForm() {

		return "helloworld-form";

	}

	@RequestMapping("/processForm")
	public String processForm() {

		return "helloWorld";

	}

	@RequestMapping("/processFormTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		String theName = request.getParameter("studentName");

		theName = theName.toUpperCase();

		String result = "Yo! " + theName;

		model.addAttribute("message", result);

		return "helloWorld";

	}

	@GetMapping("/processFormThree")
	public String processFormThree(@RequestParam("studentName") String theName, Model model) {

		// String theName = request.getParameter("studentName");

		theName = theName.toUpperCase();

		String result = "Hey! " + theName;

		model.addAttribute("message", result);

		return "helloWorld";

	}

}
