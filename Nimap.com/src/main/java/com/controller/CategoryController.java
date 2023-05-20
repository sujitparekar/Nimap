package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Category;
import com.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryService service;

	@GetMapping("/categories")
	public List<Category> getAll() {
		return service.getAll();
	}

	@PostMapping("categories")
	public String addCategory(@RequestBody Category category) {
		return service.addCategory(category);
	}

	@GetMapping("/categories/{id}")
	public Category getByID(@PathVariable int id) {
		return service.getById(id);
	}

	@PutMapping("/categories/{id}")
	public String updateCategory(@PathVariable int id, @RequestBody Category category) {
		return service.updateCategory(id, category);
	}

	@DeleteMapping("/categories/{id}")
	public String deleteCategory(@PathVariable int id) {
		return service.deleteCategory(id);
	}
}
