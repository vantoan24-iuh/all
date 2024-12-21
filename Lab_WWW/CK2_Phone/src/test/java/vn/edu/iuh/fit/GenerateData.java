/**
 * @ (#) GenerateData.java      12/17/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */
package vn.edu.iuh.fit;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import vn.edu.iuh.fit.backend.entities.Phone;
import vn.edu.iuh.fit.backend.entities.Role;
import vn.edu.iuh.fit.backend.entities.User;
import vn.edu.iuh.fit.backend.repository.PhoneRepository;
import vn.edu.iuh.fit.backend.repository.RoleRepository;
import vn.edu.iuh.fit.backend.repository.UserRepository;


import java.util.ArrayList;
import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/17/2024
 */
@SpringBootTest
public class GenerateData {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void generateRole() {
        Role role1 = Role.builder()
                .name("admin")
                .code("ADMIN")
                .build();

        Role role2 = Role.builder()
                .name("user")
                .code("USER")
                .build();

        roleRepository.save(role1);
        roleRepository.save(role2);
    }

    @Test
    public void generateUser() {
        Role role = roleRepository.findById(1L).get();
        List<Role> roles1 = new ArrayList<>();
        roles1.add(role);
        User user1 = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("123"))
                .roles(roles1)
                .build();

        Role role2 = roleRepository.findById(2L).get();
        List<Role> roles2= new ArrayList<>();
        roles2.add(role2);
        User user2 = User.builder()
                .username("user")
                .password(passwordEncoder.encode("123"))
                .roles(roles2)
                .build();

        userRepository.save(user1);
        userRepository.save(user2);
    }

    @Test
    public void generateCandidate() {
        Faker faker = new Faker();
        for (int i = 1; i <= 20; i++) {
            Phone phone = Phone.builder()
                    .name(faker.phoneNumber().cellPhone())
                    .price(faker.number().randomDouble(2, 100, 1000))
                    .category(faker.app().name())
                    .supplier(faker.company().name())
                    .address(faker.address().fullAddress())
                    .build();

            phoneRepository.save(phone);

        }
    }




}
