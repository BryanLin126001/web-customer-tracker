package ntt.global.controller;

import ntt.global.entity.Customer;
import ntt.global.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model model)
    {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("showFormForAdd")
    public String showFormForAdd(Model model)
    {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("SaveCustomer")
    public String SaveCustomer(@ModelAttribute("customer") Customer customer)
    {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("showFormforUpdate")
    public String showFormforUpdate(@RequestParam("customerId") int customerId, Model model)
    {
        Customer customer = customerService.getCustomerById(customerId);
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("delete")
    public String deleteCustomer(@RequestParam("customerId") int customerId)
    {
        customerService.deleteCustomer(customerId);
        return "redirect:/customer/list";
    }
}
