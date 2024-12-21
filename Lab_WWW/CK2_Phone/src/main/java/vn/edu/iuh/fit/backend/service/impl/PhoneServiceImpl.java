/**
 * @ (#) PhoneServiceImpl.java      12/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.entities.Phone;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/19/2024
 */
@Service
public class PhoneServiceImpl implements vn.edu.iuh.fit.backend.service.PhoneService{
    @Autowired
    private vn.edu.iuh.fit.backend.repository.PhoneRepository phoneRepository;
    @Override
    public Phone savePhone(Phone phone) {
        System.out.println(phone);
        return phoneRepository.save(phone);
    }

    @Override
    public Phone updatePhone(Phone phone) {
        Phone existingPhone = phoneRepository.findById(phone.getId()).get();
        if(existingPhone == null) {
            return null;
        }
        existingPhone.setName(phone.getName());
        existingPhone.setPrice(phone.getPrice());
        existingPhone.setSupplier(phone.getSupplier());
        existingPhone.setCategory(phone.getCategory());
        return phoneRepository.save(existingPhone);
    }

    @Override
    public void deletePhone(long id) {
        if(!phoneRepository.existsById(id)) {
            return;
        }
        phoneRepository.deleteById(id);
    }

    @Override
    public Phone getPhone(long id) {
        return phoneRepository.findById(id).get();
    }

    @Override
    public List<Phone> getPhones() {
        return phoneRepository.findAll();
    }

    @Override
    public boolean existsById(long id) {
        return phoneRepository.existsById(id);
    }
}
