/**
 * @ (#) ThuocDTO.java      10/22/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.dtos;

import jakarta.persistence.Column;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/22/2024
 */
public class ThuocDTO {
    private long maThuoc;
    private String tenThuoc;
    private double donGia;
    private int namSX;
    private String loaiThuoc;

    public ThuocDTO() {
    }

    public ThuocDTO(long maThuoc, String tenThuoc, double donGia, int namSX, String loaiThuoc) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.donGia = donGia;
        this.namSX = namSX;
        this.loaiThuoc = loaiThuoc;
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

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public String getLoaiThuoc() {
        return loaiThuoc;
    }

    public void setLoaiThuoc(String loaiThuoc) {
        this.loaiThuoc = loaiThuoc;
    }
}
