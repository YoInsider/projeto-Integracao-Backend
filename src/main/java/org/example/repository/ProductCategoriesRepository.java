package org.example.repository;

import org.example.model.ProductCategories;
import org.hibernate.Session;

import java.util.List;

public class ProductCategoriesRepository {

    public List<ProductCategories> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<ProductCategories> lista = session.createQuery("from ProductCategories", ProductCategories.class).list();
        return lista;
    }
}
