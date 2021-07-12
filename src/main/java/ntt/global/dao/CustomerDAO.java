package ntt.global.dao;

import ntt.global.entity.Customer;

import java.util.List;

public interface CustomerDAO
{
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    void deleteCustomer(int customerId);
}
