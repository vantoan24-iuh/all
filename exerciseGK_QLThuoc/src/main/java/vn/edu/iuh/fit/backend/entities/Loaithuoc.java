/**
 * @ (#) Loaithuoc.java      10/22/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/22/2024
 */
@Entity
@Table(name = "loai_thuoc")
public class Loaithuoc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maLoaiThuoc;

    @Column(name="ten_loai")
    private String tenLoaiThuoc;

    public Loaithuoc() {
    }

    public Loaithuoc(long maLoaiThuoc, String tenLoaiThuoc) {
        this.maLoaiThuoc = maLoaiThuoc;
        this.tenLoaiThuoc = tenLoaiThuoc;
    }

    public long getMaLoaiThuoc() {
        return maLoaiThuoc;
    }

    public void setMaLoaiThuoc(long maLoaiThuoc) {
        this.maLoaiThuoc = maLoaiThuoc;
    }

    public String getTenLoaiThuoc() {
        return tenLoaiThuoc;
    }

    public void setTenLoaiThuoc(String tenLoaiThuoc) {
        this.tenLoaiThuoc = tenLoaiThuoc;
    }


}
