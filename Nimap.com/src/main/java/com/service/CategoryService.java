package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CategoryDao;
import com.entity.Category;

@Service
public class CategoryService {
	@Autowired
	CategoryDao dao;

	public List<Category> getAll() {
		return dao.getAll();
	}

	public String addCategory(Category category) {
		return dao.addCategory(category);
	}

	public Category getById(int id) {
		return dao.getById(id);
	}

	public String updateCategory(int id, Category category) {
		return dao.updateCategory(id, category);
	}

	public String deleteCategory(int id) {
		return dao.deleteCategory(id);
	}

}
