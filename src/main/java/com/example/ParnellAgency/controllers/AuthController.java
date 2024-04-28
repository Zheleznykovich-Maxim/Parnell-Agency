package com.example.ParnellAgency.controllers;
import com.example.ParnellAgency.models.Client;
import com.example.ParnellAgency.models.User;
import com.example.ParnellAgency.models.dto.UserDto;
import com.example.ParnellAgency.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class AuthController {
    private UserService userService;
    // handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index/index";
    }

    // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "index/login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "index/register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        Client existingClient = userService.findClientByEmail(userDto.getEmail());

        if(existingClient != null && existingClient.getEmail() != null && !existingClient.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveClient(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String users(Model model){
            List<UserDto> users = userService.findAllClients();
        model.addAttribute("users", users);
        return "index/users";
    }
}
