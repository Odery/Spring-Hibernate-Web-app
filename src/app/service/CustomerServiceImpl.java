package app.service;

import app.dao.CustomerDAO;
import app.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomerList();
    }

    @Override
    public Customer newCustomer() {
        return new Customer();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveOrUpdateCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        customerDAO.saveOrUpdateCustomer(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(customerDAO.getCustomer(id));
    }

    @Override
    @Transactional
    public List<Customer> searchCustomers(String search) {
        search = search.toLowerCase();

        List<Customer> customers = new ArrayList<>();
        for (Customer customer : customerDAO.getCustomerList()) {
            if (customer.getFirstName().toLowerCase().contains(search)
                    || customer.getLastName().toLowerCase().contains(search)
                    || customer.getEmail().toLowerCase().contains(search)) {
                customers.add(customer);
            }
        }
        return customers;
    }
}
