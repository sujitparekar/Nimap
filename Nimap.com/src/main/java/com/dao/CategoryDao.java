package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Category;
import com.entity.Product;

@Repository
public class CategoryDao {
	@Autowired
	SessionFactory sf;

	public List<Category> getAll() {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Category.class);
		return cri.list();
	}

	public String addCategory(Category category) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(category);
		for (Product p : category.getProduct()) {
			p.setCategory(category);
			session.save(p);
		}
		tr.commit();
		return "Data Added Successful";
	}

	public Category getById(int id) {
		Session session = sf.openSession();
		return session.get(Category.class, id);
	}

	public String updateCategory(int id, Category category) {
		Session session = sf.openSession();
		category.setId(id);
		Transaction tr = session.beginTransaction();
		session.update(category);
		tr.commit();
		return "updated";
	}

	public String deleteCategory(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(session.get(Category.class, id));
		tr.commit();

		return "deleted";
	}
}
