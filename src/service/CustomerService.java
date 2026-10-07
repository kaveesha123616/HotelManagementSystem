package service;

import dao.CustomerDAO;
import java.util.List;
import model.Customer;

public class CustomerService {

    private CustomerDAO customerDAO;

    public CustomerService() {
        customerDAO = new CustomerDAO();
    }

    public boolean addCustomer(Customer customer) {
        return customerDAO.addCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }
    public boolean updateCustomer(Customer customer) {
    return customerDAO.updateCustomer(customer);
}
    public boolean deleteCustomer(int customerId) {
    return customerDAO.deleteCustomer(customerId);
}
}