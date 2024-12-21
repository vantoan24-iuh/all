/**
 * @ (#) PhoneRepository.java      12/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.entities.Phone;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/19/2024
 */
@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
