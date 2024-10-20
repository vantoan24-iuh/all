package vn.edu.iuh.fit.week01_lab.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class GrantAccessId implements Serializable {
    private static final long serialVersionUID = -106741217008652704L;
    @Column(name = "role_id", nullable = false, length = 50)
    private String roleId;

    @Column(name = "account_id", nullable = false, length = 50)
    private String accountId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GrantAccessId entity = (GrantAccessId) o;
        return Objects.equals(this.accountId, entity.accountId) &&
                Objects.equals(this.roleId, entity.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, roleId);
    }

}