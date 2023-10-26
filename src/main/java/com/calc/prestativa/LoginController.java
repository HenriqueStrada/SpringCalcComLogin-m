package com.calc.prestativa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Importe esta classe
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller // Use @Controller em vez de @RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/processForm")
    public ModelAndView processForm(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("action") String action) {
        ModelAndView modelAndView = new ModelAndView("index");

        User newUser = new User();

        if ("register".equals(action)) {
            if (userRepository.findByUsername(username) != null) {
                modelAndView.addObject("message", "Usuário já existe. Por favor, escolha outro nome de usuário.");
            } else {
                newUser.setUsername(username);
                newUser.setPassword(password);
                userRepository.save(newUser);
                modelAndView.addObject("message", "Usuário registrado com sucesso!");
            }
        } else if ("login".equals(action)) {
            User user = userRepository.findByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                modelAndView.addObject("username", username); // Adiciona o nome de usuário ao modelo
                modelAndView.addObject("message", "Login bem sucedido!");
            } else {
                modelAndView.addObject("message", "Falha no login. Por favor, tente novamente.");
            }
        } else {
            modelAndView.addObject("message", "Ação inválida.");
        }

        return modelAndView;
    }

    @GetMapping("/home")
    public String home(Model model, @RequestParam(value = "username", required = false) String username) {
        if (username != null) {
            model.addAttribute("username", username);
        }
        return "index";
    }
}
