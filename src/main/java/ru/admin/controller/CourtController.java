package ru.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.admin.model.Court;
import ru.admin.model.Employee;
import ru.admin.model.User;
import ru.admin.service.CourtService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CourtController {

    private final CourtService courtService;

    public CourtController(CourtService courtService) {
        this.courtService = courtService;
    }

    @GetMapping("/courts")
    public String courts(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setName("Администратор");
        }
        model.addAttribute("user", user);
        model.addAttribute("courts", courtService.findAllCourt());
        return "courts";
    }

    @GetMapping("/formAddCourts")
    public String formAddEmployees(Model model) {
        model.addAttribute("courts", courtService.findAllCourt());
        return "addCourts";
    }

    @PostMapping("/createCourts")
    public String createCourts(@ModelAttribute Court court) {
        courtService.add(court);
        return "redirect:/courts";
    }
}
