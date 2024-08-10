package com.Noworking.services.impl;

import com.Noworking.dto.RoleDTO;
import com.Noworking.dto.UserDTO;
import com.Noworking.entities.Role;
import com.Noworking.entities.User;
import com.Noworking.exceptions.DataNotFoundException;
import com.Noworking.repositories.RoleRepository;
import com.Noworking.repositories.UserRepository;
import com.Noworking.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("User with id " + id + " not found")
        );
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        Set<RoleDTO> roleDTOS = userDTO.getRoles();
        for (RoleDTO role : roleDTOS) {
            if(!roleRepository.existsByIdAndName(role.getId(), role.getName())) {
                throw new DataNotFoundException("Role with id " + role.getId() + " and name "+ role.getName()+" not found");
            }
        }
        User user = modelMapper.map(userDTO, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("User with id " + id + " not found")
        );
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("User with id " + id + " not found")
        );
        userRepository.delete(user);

    }

    @Override
    public List<UserDTO> getAllUsers(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        List<User> list = users.get().toList();
        return list.stream().map(e->{
            Set<Role> roles = roleRepository.findByUsers(e);
            e.setRoles(roles);
            return modelMapper.map(e, UserDTO.class);
        }).collect(Collectors.toList());
    }
}
