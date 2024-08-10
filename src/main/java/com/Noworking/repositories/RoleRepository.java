package com.Noworking.repositories;

import com.Noworking.entities.Role;
import com.Noworking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Add custom query methods if needed
    Role findByName(String name);

    boolean existsByIdAndName(long id, String name);
    Set<Role> findByUsers(User user);
//    boolean existsByNameAndUser(String name, User user);
}
