package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductDao;
import com.entity.Category;
import com.entity.Product;

@Service
public class ProductService {
	@Autowired
	ProductDao dao;

	public List<Product> getAll() {
		return dao.getAll();
	}

	public String addProduct(Product product, int id) {
		return dao.addProduct(product, id);
	}

	public Product getById(int id) {
		return dao.getById(id);
	}

	public String updateProduct(int id, Product product) {
		return dao.updateProduct(id, product);
	}

	public String deleteProduct(int id) {
		return dao.deleteProduct(id);
	}

}
