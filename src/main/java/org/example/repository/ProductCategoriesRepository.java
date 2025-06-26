package org.example.repository;

import org.example.model.ProductCategories;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductCategoriesRepository {

    public List<ProductCategories> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductCategories> categoriesList = session.createQuery("from ProductCategories", ProductCategories.class).list();
        session.close();
        return categoriesList;
    }
}
