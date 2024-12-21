package vn.edu.iuh.fit.backend.resoures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.entities.Dienthoai;
import vn.edu.iuh.fit.backend.services.DienThoaiService;

import java.util.List;

@RestController
@RequestMapping("/api/dt")
public class DienThoaiResoure {
    @Autowired
    private DienThoaiService dienThoaiService;

    @RequestMapping({"/",""})
    public ResponseEntity<List<Dienthoai>> getAllDienThoai(){
        List<Dienthoai> dienthoais = dienThoaiService.getAllDienThoai();
        System.out.println(dienthoais);
        return ResponseEntity.ok(dienthoais);
    }
    //search
    @RequestMapping("/search/{id}")
    public ResponseEntity<Dienthoai> getDienThoaiById(@PathVariable("id") Long id) {
        Dienthoai dienthoai = dienThoaiService.getDienThoaiById(id);
        if (dienthoai == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dienthoai);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePhone(@PathVariable("id") long id) {
        if (!dienThoaiService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        dienThoaiService.deleteDienThoai(id);
        return ResponseEntity.noContent().build();
    }

    //save
    @PostMapping
    public ResponseEntity<Dienthoai> saveDienThoai(@RequestBody Dienthoai dienthoai) {
        return ResponseEntity.ok(dienThoaiService.addDienThoai(dienthoai));
    }

    //update
    @PutMapping("/update")
    public ResponseEntity<Dienthoai> updatePhone(@RequestBody Dienthoai dienthoai) {
        return ResponseEntity.ok(dienThoaiService.updateDienThoai(dienthoai));
    }

}