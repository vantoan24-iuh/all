/**
 * @ (#) RoleRepository.java      12/3/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.entities.Role;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/3/2024
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
