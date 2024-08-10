package com.Noworking.CommandLineRunner;

import com.Noworking.entities.Role;
import com.Noworking.repositories.RoleRepository;
import com.Noworking.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class RoleCommandLineRunner {

    @Autowired
    RoleService roleService;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            roleService.addRole("ROLE_USER");
            roleService.addRole("ROLE_ADMIN");
            roleService.addRole("ROLE_MODERATOR");
            roleService.addRole("ROLE_SUPPORT");
            roleService.addRole("ROLE_SUPER_ADMIN");
            roleService.addRole("ROLE_VIEWER");
            roleService.addRole("ROLE_PRODUCT");
        };
    }

}
