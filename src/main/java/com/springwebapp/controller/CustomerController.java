package com.springwebapp.controller;

import com.springwebapp.entity.Customer;
import com.springwebapp.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("customers", customerService.getCustomers());
        model.addAttribute("search");

        return "customer-list";
    }

    @GetMapping("/add")
    public String addCustomer(Model model) {
        model.addAttribute("customer", customerService.newCustomer());

        return "addCustomer";
    }

    @PostMapping("/add")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/update")
    public String loadCustomer(Model model, @ModelAttribute("id") int id) {

        model.addAttribute("customer", customerService.getCustomer(id));

        return "update";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.updateCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@ModelAttribute("id") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

    @GetMapping("search-list")
    public String doSearch(Model model, @ModelAttribute("search") String search) {
        if (!search.isEmpty()) {
            model.addAttribute("customers", customerService.searchCustomers(search));

            model.addAttribute("search", search);
            return "customer-list";
        } else {
            return "redirect:/customer/list";
        }
    }
}