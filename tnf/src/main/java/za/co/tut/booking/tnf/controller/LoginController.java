package za.co.tut.booking.tnf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/login")
public class LoginController {

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;

    @PostMapping("/login")
    public String performLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {
        if (adminUsername.equals(username) && adminPassword.equals(password)) {
            return "redirect:/admin.html"; // Redirect to admin.html in static folder
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Redirect to login.html with error message
        }
    }
}
