/**
 * @ (#) QLThuocService.java      10/22/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.services;

import jakarta.ejb.Remote;
import vn.edu.iuh.fit.backend.dtos.ThuocDTO;
import vn.edu.iuh.fit.backend.entities.Loaithuoc;
import vn.edu.iuh.fit.backend.entities.Thuoc;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/22/2024
 */
@Remote
public interface QLThuocService {

    public List<ThuocDTO> getAllDTO();
    public List<Loaithuoc> getAllLoaiThuoc();
    public List<ThuocDTO> getListThuocByLoai(long maLoaiThuoc);
    public boolean save(Thuoc thuoc);
    public Loaithuoc getById(long id);
}
