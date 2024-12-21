/**
 * @ (#) Thuoc.java      10/22/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/22/2024
 */

@Entity
@Table(name = "thuoc")
public class Thuoc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_thuoc")
    private long maThuoc;

    @Column(name="ten_thuoc")
    private String tenThuoc;

    @Column(name="don_gia")
    private double donGia;

    @Column(name="namSX")
    private int namSanXuat;

    @ManyToOne
    @JoinColumn(name = "ma_loai_thuoc")
    private Loaithuoc loaiThuoc;

    public Thuoc(String tenThuoc, double donGia, int namSanXuat) {
        this.tenThuoc = tenThuoc;
        this.donGia = donGia;
        this.namSanXuat = namSanXuat;
    }

    public Thuoc() {
    }

    public Thuoc(long maThuoc, String tenThuoc, double donGia, int namSanXuat) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.donGia = donGia;
        this.namSanXuat = namSanXuat;
    }

    public long getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(long maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public Loaithuoc getLoaiThuoc() {
        return loaiThuoc;
    }

    public void setLoaiThuoc(Loaithuoc loaiThuoc) {
        this.loaiThuoc = loaiThuoc;
    }
}
