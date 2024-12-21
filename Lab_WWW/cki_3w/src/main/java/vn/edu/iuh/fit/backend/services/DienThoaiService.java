package vn.edu.iuh.fit.backend.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.entities.Dienthoai;

import java.util.List;

public interface DienThoaiService {
    List<Dienthoai> getAllDienThoai();
    Dienthoai getDienThoaiById(Long id);
    Dienthoai addDienThoai(Dienthoai dienthoai);
    void deleteDienThoai(Long id);
    boolean existsById(long id);
    Dienthoai updateDienThoai(Dienthoai dienthoai);
}
