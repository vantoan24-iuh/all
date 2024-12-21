/**
 * @ (#) UserServiceImpl.java      12/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.entities.User;
import vn.edu.iuh.fit.backend.repository.UserRepository;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/19/2024
 */
@Service
public class UserServiceImpl implements vn.edu.iuh.fit.backend.service.UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
