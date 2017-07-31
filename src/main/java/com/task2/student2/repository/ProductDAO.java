//package com.task2.student2.repository;
//
//import com.task2.student2.model.Product;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.springframework.stereotype.Repository;
//
//import javax.security.auth.login.Configuration;
//import java.util.ArrayList;
//import java.util.List;
//
//
////
//@Repository
//public class ProductDAO {
//
//    private SessionFactory sessionFactory = new Configuration().configure().buildS;
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public void save(Product prod){
//        Session session = this.sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        session.persist(prod);
//        tx.commit();
//        session.close();
//    }
//
//    List<Product> productList = new ArrayList<>();
//    {
//        Product product1 = new Product(1, "T-shirt");
//        Product product2 = new Product(2, "Shoes");
////        save(product1);
////        save(product2);
//        productList.add(product1);
//        productList.add(product2);
//    }
//
//    public List<Product> getAllProducts(){
//        return this.productList;
//    }
//
//    public List<Product> getAllProductsDB() {
//        Session session = this.sessionFactory.openSession();
//        List<Product> productList = session.createQuery("from Product ").list();
//        session.close();
//        return productList;
//    }
//}
