package vn.edu.iuh.fit.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.backend.entities.Dienthoai;
import vn.edu.iuh.fit.backend.repositories.DienThoaiRepository;
import vn.edu.iuh.fit.backend.services.DienThoaiService;
import vn.edu.iuh.fit.frontend.model.DienThoaiModel;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/dt")
public class DienThoaiController {

    @Autowired
    private DienThoaiService dienThoaiService;

    @Autowired
    private DienThoaiRepository dienThoaiRepository;

    @Autowired
    private DienThoaiModel  dienThoaiModel;

    @GetMapping({"","/", "/login"})
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/list")
    public String getAllDienThoai(Model model) {
//        model.addAttribute("phones", dienThoaiRepository.findAll());
        model.addAttribute("phones", dienThoaiModel.getPhones());
        return "phoneList";
    }

    @GetMapping("/add")
    public ModelAndView showAddPhone() {
        ModelAndView modelAndView = new ModelAndView("addPhone");
        Dienthoai dienthoai = new Dienthoai();
        modelAndView.addObject("phones", dienthoai);
        return modelAndView;
    }

    @PostMapping("/add")
    public String addPhone(Dienthoai dienthoai) {
//        dienThoaiRepository.save(dienthoai);
        dienThoaiModel.savePhone(dienthoai);
        return "redirect:/dt/list";
    }

    @GetMapping("/admin/delete/{id}")
    public String deletePhone(@PathVariable("id") long id, Model model) {
//        dienThoaiRepository.deleteById(id);
        dienThoaiModel.deletePhone(id);
        return "redirect:/dt/list";
    }

    @GetMapping("/admin/edit/{id}")
    public String showUpdatePhone(Model model, @PathVariable long id) {
        model.addAttribute("phones", dienThoaiModel.getPhone(id));
        return "addPhone";
    }
    @PostMapping("/admin/edit/{id}")
    public String updatePhone(Dienthoai dienthoai) {
        dienThoaiModel.updatePhone(dienthoai);
        return "redirect:/dt/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam(required = false) Long id, Model model) {
        List<Dienthoai> phones;
        if (id != null) {
            Dienthoai phone = dienThoaiModel.getPhone(id);
            phones = (phone != null) ? Collections.singletonList(phone) : Collections.emptyList();
        } else {
            phones = dienThoaiService.getAllDienThoai();
        }
        model.addAttribute("phones", phones);
        return "phoneList";
    }

}
