package com.github.illiaderhun.simplemessagebroker;

import com.github.illiaderhun.simplemessagebroker.config.CustomUserDetails;
import com.github.illiaderhun.simplemessagebroker.entities.Role;
import com.github.illiaderhun.simplemessagebroker.entities.User;
import com.github.illiaderhun.simplemessagebroker.repositories.UserRepository;
import com.github.illiaderhun.simplemessagebroker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SimpleMessageBrokerApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SimpleMessageBrokerApplication.class, args);
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserService userService) throws Exception {
        if (repository.count() == 0)
            userService.save(new User("admin", "admin", Role.ADMIN));
        builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
    }

    private UserDetailsService userDetailsService(final UserRepository repository) {
        return username -> new CustomUserDetails(repository.findByUsername(username));
    }

}
