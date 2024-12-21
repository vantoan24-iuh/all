package vn.edu.iuh.fit.backend.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import vn.edu.iuh.fit.backend.entities.Dienthoai;
import vn.edu.iuh.fit.backend.repositories.DienThoaiRepository;
import vn.edu.iuh.fit.backend.services.DienThoaiService;

import java.util.List;

public class DienThoaiImpService implements DienThoaiService {
    @Autowired
    private DienThoaiRepository dienThoaiRepository;


    @Override
    public List<Dienthoai> getAllDienThoai() {
        return dienThoaiRepository.findAll();
    }

    @Override
    public Dienthoai getDienThoaiById(Long id) {
        return dienThoaiRepository.findById(id).orElse(null);
    }

    @Override
    public Dienthoai saveDienThoai(Dienthoai dienthoai) {
        return null;
    }

    @Override
    public void deleteDienThoai(Long id) {

    }

    @Override
    public Dienthoai updateDienThoai(Dienthoai dienthoai) {
        return null;
    }
}
