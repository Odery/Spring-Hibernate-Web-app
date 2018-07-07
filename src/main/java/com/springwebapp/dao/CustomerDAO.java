package com.springwebapp.dao;

import com.springwebapp.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomerList();

    Customer getCustomer(int id);

    void saveOrUpdateCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
