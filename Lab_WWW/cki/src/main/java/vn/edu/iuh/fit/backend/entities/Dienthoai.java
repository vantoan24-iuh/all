package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dienthoai")
public class Dienthoai {
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

}