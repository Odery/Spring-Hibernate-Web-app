package app.dao;

import app.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    private SessionFactory factory;

    public CustomerDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    @Transactional
    public List<Customer> getCustomerList() {
        Session session = factory.getCurrentSession();

        Query<Customer> query = session.createQuery("from Customer", Customer.class);

        return query.getResultList();
    }
}
