package ru.burn.AuthorizationService.repository;

import ru.burn.AuthorizationService.model.Authorities;
import ru.burn.AuthorizationService.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    //private
    static Map<User, List<Authorities>> userAuthorities;

    public UserRepository() {
        userAuthorities = new ConcurrentHashMap<>();
        userAuthorities.put(new User("Ivan", "1010"),
                Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        userAuthorities.put(new User("Nataliya", "1011"),
                Arrays.asList(Authorities.WRITE, Authorities.DELETE));
        userAuthorities.put(new User("Alex", "1012"),
                Arrays.asList(Authorities.WRITE));

    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        return userAuthorities.get(new User(user, password));
    }
}
