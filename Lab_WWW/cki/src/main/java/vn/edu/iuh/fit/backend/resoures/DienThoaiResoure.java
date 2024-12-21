package vn.edu.iuh.fit.backend.resoures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.backend.entities.Dienthoai;
import vn.edu.iuh.fit.backend.services.DienThoaiService;

import java.util.List;

@RestController
@RequestMapping("/api/dt")
public class DienThoaiResoure {
    @Autowired
    private DienThoaiService dienThoaiService;

    @RequestMapping("/list")
    public ResponseEntity<List<Dienthoai>> getAllDienThoai(){
        List<Dienthoai> dienthoais = dienThoaiService.getAllDienThoai();
        return ResponseEntity.ok(dienthoais);
    }
}