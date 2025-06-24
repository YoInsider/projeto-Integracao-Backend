package org.example.repository;

import org.example.model.ProductLines;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductLinesRepository {

    public List<ProductLines> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductLines> linesList = session.createQuery("from ProductLines", ProductLines.class).list();
        session.close();
        return linesList;
    }
}
