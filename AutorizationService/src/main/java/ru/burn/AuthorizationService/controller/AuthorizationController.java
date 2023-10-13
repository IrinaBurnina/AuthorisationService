package ru.burn.AuthorizationService.controller;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.burn.AuthorizationService.model.Authorities;
import ru.burn.AuthorizationService.model.User;
import ru.burn.AuthorizationService.repository.UserRepository;
import ru.burn.AuthorizationService.service.AuthorizationService;

import java.util.List;

@RestController
@Validated
public class AuthorizationController {
    AuthorizationService service = new AuthorizationService(new UserRepository());

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }
}
