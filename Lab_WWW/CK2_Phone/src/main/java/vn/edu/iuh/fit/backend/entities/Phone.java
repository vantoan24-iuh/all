/**
 * @ (#) Phone.java      12/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/19/2024
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "phone")
public class Phone implements Serializable {

    @Id
    @Column(name = "phone_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "phone_name", nullable = false)
    private String name;
    private String address;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String supplier;
}
