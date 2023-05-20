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
public class ProductDao {
	@Autowired
	SessionFactory sf;

	public List<Product> getAll() {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Product.class);
		return cr.list();
	}

	public String addProduct(Product product, int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		product.setCategory(session.get(Category.class, id));
		session.save(product);
		tr.commit();
		return "Product Added";
	}

	public Product getById(int id) {
		Session session = sf.openSession();
		return session.get(Product.class, id);
	}

	public String updateProduct(int id, Product product) {
		Session session = sf.openSession();
		Product p = session.get(Product.class, id);
		p.setName(product.getName());
		Transaction tr = session.beginTransaction();
		session.update(p);
		tr.commit();
		return "Update";
	}

	public String deleteProduct(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(session.get(Product.class, id));
		tr.commit();
		return "deleted";
	}

}
