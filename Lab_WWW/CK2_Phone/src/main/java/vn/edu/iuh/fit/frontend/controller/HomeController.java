/**
 * @ (#) HomeController.java      12/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.fit.backend.entities.Phone;
import vn.edu.iuh.fit.frontend.models.PhoneModels;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/19/2024
 */
@Controller
public class HomeController {
    @Autowired
    private PhoneModels phoneModels;

    @GetMapping({"","/", "/login"})
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/index")
    public String home(Model model) {
        model.addAttribute("phones", phoneModels.getPhones());
        return "index";
    }

    @GetMapping("/phones/{id}")
    public String getPhone(Model model, @PathVariable long id) {
        model.addAttribute("phone", phoneModels.getPhone(id));
        return "phone_detail";
    }

    @GetMapping("/user/phones/add_new")
    public String addPhone(Model model) {
        model.addAttribute("phone", new Phone());
        return "form-phone";
    }

    @PostMapping("/phones/save")
    public String savePhone(Model model, Phone phone) {
        phoneModels.savePhone(phone);
        return "redirect:/index";
    }

    @GetMapping("/admin/phones/{id}/edit")
    public String addPhone(Model model, @PathVariable long id) {
        model.addAttribute("phone", phoneModels.getPhone(id));
        return "form-phone";
    }

    @GetMapping("/admin/phones/{id}/delete")
    public String deletePhone(Model model, @PathVariable long id) {
        phoneModels.deletePhone(id);
        return "redirect:/index";
    }
}
