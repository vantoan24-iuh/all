/**
 * @ (#) PhoneService.java      12/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.service;

import vn.edu.iuh.fit.backend.entities.Phone;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/19/2024
 */
public interface PhoneService {
    public Phone savePhone(Phone phone);
    public Phone updatePhone(Phone phone);
    public void deletePhone(long id);
    public Phone getPhone(long id);
    public List<Phone> getPhones();

    boolean existsById(long id);
}
