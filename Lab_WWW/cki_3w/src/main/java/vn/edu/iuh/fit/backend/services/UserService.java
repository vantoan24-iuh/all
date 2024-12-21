package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.entities.User;

public interface UserService {
    public User getUserByUsername(String username);
}
