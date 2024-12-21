package vn.edu.iuh.fit.backend.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.entities.Dienthoai;
import vn.edu.iuh.fit.backend.repositories.DienThoaiRepository;
import vn.edu.iuh.fit.backend.services.DienThoaiService;

import java.util.List;

@Service
public class DienThoaiImpService implements DienThoaiService {
    @Autowired
    private DienThoaiRepository dienThoaiRepository;

    @Override
    public List<Dienthoai> getAllDienThoai() {
        System.out.println(dienThoaiRepository.findAll());
        return dienThoaiRepository.findAll();
    }

    @Override
    public Dienthoai getDienThoaiById(Long id) {
        return dienThoaiRepository.findById(id).orElse(null);
    }

    @Override
    public Dienthoai addDienThoai(Dienthoai dienthoai) {
        return dienThoaiRepository.save(dienthoai);
    }

    @Override
    public void deleteDienThoai(Long id) {
        dienThoaiRepository.deleteById(id);
    }

    @Override
    public boolean existsById(long id) {
        return dienThoaiRepository.existsById(id);
    }

    @Override
    public Dienthoai updateDienThoai(Dienthoai dienthoai) {
        Dienthoai existingDienthoai = dienThoaiRepository.findById(dienthoai.getId()).get();
        if (existingDienthoai == null) {
            return null;
        }
        existingDienthoai.setTenDT(dienthoai.getTenDT());
        existingDienthoai.setDiaChi(dienthoai.getDiaChi());
        existingDienthoai.setGiaVon(dienthoai.getGiaVon());
        existingDienthoai.setLoai(dienthoai.getLoai());
        existingDienthoai.setNhaCungCap(dienthoai.getNhaCungCap());
        return dienThoaiRepository.save(existingDienthoai);
    }

}
