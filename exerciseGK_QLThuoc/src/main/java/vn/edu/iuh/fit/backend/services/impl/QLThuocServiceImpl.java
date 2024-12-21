/**
 * @ (#) QLThuocServiceImpl.java      10/22/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services.impl;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.backend.dtos.ThuocDTO;
import vn.edu.iuh.fit.backend.entities.Loaithuoc;
import vn.edu.iuh.fit.backend.entities.Thuoc;
import vn.edu.iuh.fit.backend.repositories.QLThuocRepository;
import vn.edu.iuh.fit.backend.services.QLThuocService;

import java.util.ArrayList;
import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/22/2024
 */
@Stateless
public class QLThuocServiceImpl implements QLThuocService {

    @Inject
    private QLThuocRepository qlThuocRepository;

    @Override
    public List<ThuocDTO> getAllDTO() {
        List<ThuocDTO> thuocDTOS = new ArrayList<>();
        List<Thuoc> medicines = qlThuocRepository.getAll();
        medicines.forEach(medicine -> {
            Loaithuoc loaithuoc = qlThuocRepository.getById(medicine.getLoaiThuoc().getMaLoaiThuoc());
            ThuocDTO thuocDTO = new ThuocDTO();
            thuocDTO.setMaThuoc(medicine.getMaThuoc());
            thuocDTO.setTenThuoc(medicine.getTenThuoc());
            thuocDTO.setDonGia(medicine.getDonGia());
            thuocDTO.setNamSX(medicine.getNamSanXuat());
            thuocDTO.setLoaiThuoc(loaithuoc.getTenLoaiThuoc());
            thuocDTOS.add(thuocDTO);
        });
        return thuocDTOS;
    }

    @Override
    public List<Loaithuoc> getAllLoaiThuoc() {
        return qlThuocRepository.getAllLoaiThuoc();
    }

    @Override
    public List<ThuocDTO> getListThuocByLoai(long maLoaiThuoc) {
        List<ThuocDTO> thuocDTOS = new ArrayList<>();
        List<Thuoc> medicines = qlThuocRepository.getListThuocByLoai(maLoaiThuoc);
        medicines.forEach(medicine -> {
            Loaithuoc loaithuoc = qlThuocRepository.getById(medicine.getLoaiThuoc().getMaLoaiThuoc());
            ThuocDTO thuocDTO = new ThuocDTO();
            thuocDTO.setMaThuoc(medicine.getMaThuoc());
            thuocDTO.setTenThuoc(medicine.getTenThuoc());
            thuocDTO.setDonGia(medicine.getDonGia());
            thuocDTO.setNamSX(medicine.getNamSanXuat());
            thuocDTO.setLoaiThuoc(loaithuoc.getTenLoaiThuoc());
            thuocDTOS.add(thuocDTO);
        });
        return thuocDTOS;
    }

    @Override
    public boolean save(Thuoc thuoc) {
        return qlThuocRepository.save(thuoc);
    }

    @Override
    public Loaithuoc getById(long id) {
        return qlThuocRepository.getById(id);
    }
}
