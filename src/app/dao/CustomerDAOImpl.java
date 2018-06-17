package app.dao;

import app.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    private SessionFactory factory;

    public CustomerDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @SuppressWarnings("JpaQlInspection")
    @Override
    public List<Customer> getCustomerList() {
        Session session = factory.getCurrentSession();

        Query<Customer> query = session.createQuery("from Customer", Customer.class);

        return query.getResultList();
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = factory.getCurrentSession();

        return session.get(Customer.class, id);
    }

    @Override
    public void saveOrUpdateCustomer(Customer customer) {
        Session session = factory.getCurrentSession();

        session.saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        Session session = factory.getCurrentSession();

        session.delete(customer);
    }
}
