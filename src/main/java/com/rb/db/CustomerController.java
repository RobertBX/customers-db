package com.rb.db;


import com.rb.db.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customerList";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }


    @PostMapping("/add")
    @Transactional
    public String add(@ModelAttribute Customer customer, Model model,
                      RedirectAttributes redirectAttributes, BindingResult result) {
        if (result.hasErrors()) {
            return "customerForm";
        }
        if (customer.getId() == null) {
            redirectAttributes.addFlashAttribute("message", "User added!");
        } else {
            redirectAttributes.addFlashAttribute("message", "User updated!");
        }

        customerRepository.save(customer);

        return "redirect:/customer";
    }


}
