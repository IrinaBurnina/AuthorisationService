package ru.burn.AuthorizationService.service;

import ru.burn.AuthorizationService.exception.InvalidCredentials;
import ru.burn.AuthorizationService.exception.UnauthorizedUser;
import ru.burn.AuthorizationService.model.Authorities;
import ru.burn.AuthorizationService.repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    private UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}

