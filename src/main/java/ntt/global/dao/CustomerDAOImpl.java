package ntt.global.dao;

import ntt.global.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{

    SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers()
    {
        Session session =  sessionFactory.getCurrentSession();
        List<Customer> result = session.createQuery("from Customer order by lastName").getResultList();
        return result;
    }

    @Override
    public void saveCustomer(Customer customer)
    {
        Session session =  sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomerById(int customerId)
    {
        Session session =  sessionFactory.getCurrentSession();
        return session.get(Customer.class, customerId);
    }

    @Override
    public void deleteCustomer(int customerId)
    {
        Session session =  sessionFactory.getCurrentSession();
        session.delete(session.get(Customer.class, customerId));
    }
}
