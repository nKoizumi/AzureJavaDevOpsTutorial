package com.azuredevopstutorial.answer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.azuredevopstutorial.answer.model.Blog;
import com.azuredevopstutorial.answer.service.HomeService;

import com.microsoft.applicationinsights.TelemetryClient;

@Controller
public class HomeController {

	@Autowired
	HomeService service;
	
	private TelemetryClient telemetry = new TelemetryClient();

	@GetMapping("/")
	String index(Model model) {
		 if (service.getBlog().size() == 0) {
			Blog blog = new Blog();
			blog.name = "Hello Blog";
			service.addBlog(blog);
		}
		
		List<Blog> blogs = service.getBlog();
		model.addAttribute("blogs", blogs);
		
		return "home/index";
	}
	
	@GetMapping("/contact")
	String contact(Model model) {
		// telemetry.trackEvent("カスタムログ");
		if (1 == 1) throw new RuntimeException();
		return "home/contact";
	}
}
