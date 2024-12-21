package vn.edu.iuh.fit.backend.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.entities.Dienthoai;

import java.util.List;

@Service
public interface DienThoaiService {
    List<Dienthoai> getAllDienThoai();
    Dienthoai getDienThoaiById(Long id);
    Dienthoai saveDienThoai(Dienthoai dienthoai);
    void deleteDienThoai(Long id);
    Dienthoai updateDienThoai(Dienthoai dienthoai);
}
