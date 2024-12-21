/**
 * @ (#) RoleRepository.java      12/3/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
