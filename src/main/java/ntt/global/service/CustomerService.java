package ntt.global.service;

import ntt.global.entity.Customer;

import java.util.List;

public interface CustomerService
{
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    void deleteCustomer(int customerId);
}
