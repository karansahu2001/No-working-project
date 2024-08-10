package com.Noworking.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private int age;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String phoneNumber;
    private String createAt;
    private String updateAt;
    private int status;
    private Set<RoleDTO> roles;
}
