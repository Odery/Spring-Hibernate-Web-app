package app.service;

import app.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    Customer newCustomer();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void updateCustomer(Customer customer);
}
