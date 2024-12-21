/**
 * @ (#) Product.java      9/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week2_phantiensinh.models;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.week2_phantiensinh.enums.ProductStatus;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/18/2024
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @Column(length = 25, nullable = false)
    private String unit;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private ProductStatus status;

    @Column(name = "manufacturer_name",length = 100, nullable = false)
    private String manufacturer;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 250, nullable = false)
    private String description;

    @JsonbTransient
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @JsonbTransient
    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImageList;

    @JsonbTransient
    @OneToMany(mappedBy = "product")
    private List<ProductPrice> productPrices;

    public Product(long id, String name, String description, String unit, String manufacturer_name, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer_name;
        this.status = status;
    }

    public Product(long id, String name, String description, String unit, String manufacturer, ProductStatus status, List<ProductImage> productImageList, List<OrderDetail> orderDetails, List<ProductPrice> productPrices) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer= manufacturer;
        this.status = status;
        this.productImageList = productImageList;
        this.orderDetails = orderDetails;
        this.productPrices = productPrices;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturer='" + manufacturer+ '\'' +
                ", status=" + status +
                ", productImages=" + productImageList +
                ", orderDetails=" + orderDetails +
                ", productPrices=" + productPrices +
                '}';
    }
}
