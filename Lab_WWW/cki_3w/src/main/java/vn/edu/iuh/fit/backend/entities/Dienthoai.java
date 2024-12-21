package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "dienthoai")
public class Dienthoai implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maDT", nullable = false)
    private Long id;

    @Column(name = "tenDT", length = 50)
    private String tenDT;

    @Column(name = "diaChi", length = 50)
    private String diaChi;

    @Column(name = "giaVon")
    private Double giaVon;

    @Column(name = "loai", length = 50)
    private String loai;

    @Column(name = "nhaCungCap", length = 50)
    private String nhaCungCap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Double getGiaVon() {
        return giaVon;
    }

    public void setGiaVon(Double giaVon) {
        this.giaVon = giaVon;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public String toString() {
        return "Dienthoai{" +
                "id=" + id +
                ", tenDT='" + tenDT + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", giaVon=" + giaVon +
                ", loai='" + loai + '\'' +
                ", nhaCungCap='" + nhaCungCap + '\'' +
                '}';
    }
}