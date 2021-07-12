package ntt.global.service;

import ntt.global.dao.CustomerDAO;
import ntt.global.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService
{

    private final CustomerDAO customerDAO;


    public CustomerServiceImpl(CustomerDAO customerDAO)
    {
        this.customerDAO = customerDAO;
    }



    @Override
    @Transactional
    public List<Customer> getCustomers()
    {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer)
    {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomerById(int customerId)
    {
        return customerDAO.getCustomerById(customerId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int customerId)
    {
        customerDAO.deleteCustomer(customerId);
    }
}
