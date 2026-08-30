package ru.kata.spring.boot_security.demo.configs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.Set;

@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner initData(UserService userService,
                                      RoleService roleService) {
        return args -> {
            Role userRole = roleService.findOrCreateRole("USER");
            Role adminRole = roleService.findOrCreateRole("ADMIN");

            if (!userService.existsByUsername("user")) {
                User user = new User();
                user.setUsername("user");
                user.setPassword("user");
                user.setFirstName("Обычный");
                user.setLastName("Пользователь");
                user.setAge(25);
                user.setEmail("user@example.com");
                user.setRoles(Set.of(userRole));

                userService.createUser(user);
            }

            if (!userService.existsByUsername("admin")) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword("admin");
                admin.setFirstName("Администратор");
                admin.setLastName("Системы");
                admin.setAge(30);
                admin.setEmail("admin@example.com");
                admin.setRoles(Set.of(userRole, adminRole));

                userService.createUser(admin);
            }
        };
    }
}
