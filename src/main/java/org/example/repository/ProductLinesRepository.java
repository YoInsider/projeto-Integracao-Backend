package org.example.repository;

import org.example.model.ProductLines;
import org.hibernate.Session;

import java.util.List;

public class ProductLinesRepository {

    public List<ProductLines> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductLines> lista = session.createQuery("from ProductLines", ProductLines.class).list();
        return lista;
    }
}
