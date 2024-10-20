package vn.edu.iuh.fit.week03_phantiensinh.backend.repositories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "product_price", schema = "productdb")
@NamedQueries({
        @NamedQuery(name = "ProductPrice.findAll", query = "select p from ProductPrice p"),
        @NamedQuery(name = "ProductPrice.findByProduct_Id", query = "select p from ProductPrice p where p.product.id = :id"),
        @NamedQuery(name = "ProductPrice.deleteByProduct_Id", query = "delete from ProductPrice p where p.product.id = :id")
})
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "price_id", nullable = false)
    private Product product;

    @NotNull
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "apply_date", nullable = false)
    private Instant applyDate;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "value", nullable = false)
    private Double value;

    @Lob
    @Column(name = "note")
    private String note;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Instant getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Instant applyDate) {
        this.applyDate = applyDate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPrice that = (ProductPrice) o;
        return Objects.equals(id, that.id) && Objects.equals(product, that.product) && Objects.equals(productId, that.productId) && Objects.equals(applyDate, that.applyDate) && Objects.equals(value, that.value) && Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, productId, applyDate, value, note);
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "id=" + id +
                ", product=" + product +
                ", productId=" + productId +
                ", applyDate=" + applyDate +
                ", value=" + value +
                ", note='" + note + '\'' +
                '}';
    }
}