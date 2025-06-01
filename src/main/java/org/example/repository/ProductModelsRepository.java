package org.example.repository;

import org.example.model.ProductModels;
import org.hibernate.Session;

import java.util.List;

public class ProductModelsRepository {

    public List<ProductModels> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<ProductModels> lista = session.createQuery("from ProductModels", ProductModels.class).list();
        session.close();
        return lista;
    }
}
