/**
 * @ (#) PhoneRestController.java      12/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.entities.Phone;
import vn.edu.iuh.fit.backend.service.PhoneService;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/19/2024
 */
@RestController
@RequestMapping("/api/phones")
public class PhoneRestController {

    @Autowired
    private PhoneService phoneService;

    @RequestMapping({"/",""})
    public ResponseEntity<List<Phone>> getAllPhones() {
        return ResponseEntity.ok(phoneService.getPhones());
    }

    @PostMapping
    public ResponseEntity<Phone> savePhone(@RequestBody Phone phone) {
        System.out.println(phone);
        return ResponseEntity.ok(phoneService.savePhone(phone));
    }

    @PutMapping
    public ResponseEntity<Phone> updatePhone(@RequestBody Phone phone) {
        return ResponseEntity.ok(phoneService.updatePhone(phone));
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Phone> getPhone(@PathVariable long id) {
        return ResponseEntity.ok(phoneService.getPhone(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePhone(@PathVariable("id") long id) {
        if (!phoneService.existsById(id)) { // Kiểm tra xem mục có tồn tại hay không
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        phoneService.deletePhone(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }



}
