package com.azuredevopstutorial.answer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azuredevopstutorial.answer.model.Blog;
import com.azuredevopstutorial.answer.repository.BlogRepository;

@Service
public class HomeService {
	@Autowired
	BlogRepository rep;
	
	public String greet(int hour)
	{
		String greeting = "";
		
		// if (hour < 5) {
		//	greeting = "Good evening!";
		// }
		// else if (hour < 12) {
		if (hour < 12) {
			greeting = "Good morning!";
		} else if (hour < 18) {
			greeting = "Good afternoon!";
		} else {
			greeting = "Good evening!";
		}
		return greeting;
	}
	
	public List<Blog> getBlog() {
		return rep.findAll();
	}
	
	public void addBlog(Blog blog) {
		rep.save(blog);
	}
}
