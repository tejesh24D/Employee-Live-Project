package com.example.EmployeeLiveProject.controller;

import com.example.EmployeeLiveProject.model.Employee;
import com.example.EmployeeLiveProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String listEmployees(Model model, @AuthenticationPrincipal OAuth2User principal) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("userName", principal.getAttribute("name"));
        return "employee_list";
    }

    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add_employee";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditEmployeeForm(@PathVariable String id, Model model) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        model.addAttribute("employee", employee);
        return "edit_employee";
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(@PathVariable String id, @ModelAttribute Employee employee) {
        employee.setId(id);
        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id) {
        employeeRepository.deleteById(id);
        return "redirect:/employees";
    }
}
