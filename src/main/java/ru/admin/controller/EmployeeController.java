package ru.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.admin.model.Employee;
import ru.admin.service.CourtService;
import ru.admin.service.EmployeeService;
import ru.admin.service.PositionService;


@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CourtService courtService;
    private final PositionService positionService;

    public EmployeeController(EmployeeService employeeService, CourtService courtService, PositionService positionService) {
        this.employeeService = employeeService;
        this.courtService = courtService;
        this.positionService = positionService;
    }

    @GetMapping("/employees")
    public String courts(Model model) {
        model.addAttribute("employees", employeeService.all());
        return "employees";

    }

    @GetMapping("/formAddEmployees")
    public String formAddEmployees(Model model) {
        model.addAttribute("courts", courtService.findAllCourt());
        model.addAttribute("positions", positionService.allPos());
        return "addEmployees";
    }

    @GetMapping("/formDeleteEmployee/{itemId}")
    public String deleteTicket(Model model, @PathVariable("itemId") int id) {
        Employee employee = employeeService.findById(id);

        model.addAttribute("employee", employee);
        return "deleteEmpl";
    }

    @GetMapping("/formUpdateEmployee/{itemId}")
    public String formUpdatePost(Model model, @PathVariable("itemId") int id) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "updateEmployee";
    }

    @PostMapping("/updateEmployee")
    public String updatePost(@ModelAttribute Employee employee) {
        employeeService.update(employee);
        return "redirect:/employees";
    }

    @PostMapping("/employeeDelete")
    public String formDeleteTicket(@ModelAttribute Employee employee) {
        employeeService.delete(employee);
        return "redirect:/employees";
    }

    @PostMapping("/createEmployees")
    public String createItem(@ModelAttribute Employee employee) {
        employeeService.add(employee);
        return "redirect:/employees";
    }
}
