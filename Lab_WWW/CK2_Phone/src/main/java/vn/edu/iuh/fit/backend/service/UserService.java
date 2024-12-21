/**
 * @ (#) UserService.java      12/3/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.entities.User;


/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/3/2024
 */
@Service
public interface UserService {
    public User getUserByUsername(String username);

}
