package app.dao;

import app.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomerList();
}
