package ru.burn.AuthorizationService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.burn.AuthorizationService.model.Authorities;
import ru.burn.AuthorizationService.repository.UserRepository;
import ru.burn.AuthorizationService.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service = new AuthorizationService(new UserRepository());

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {

        return service.getAuthorities(user, password);
    }
}
