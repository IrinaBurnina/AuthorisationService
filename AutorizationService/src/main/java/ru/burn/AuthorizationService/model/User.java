package ru.burn.AuthorizationService.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class User {
    @NotBlank(message = "users name is not to be empty")
    @Size(min = 1, max = 25, message = "users name is more then 1 and less then 25 characters")
    private String name;
    @Min(value = 0000, message = "users password is not to be empty")
    @Max(9999)
    @Size(min = 4, max = 4, message = "password must have 4 characters")
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(this.name, user.name) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
