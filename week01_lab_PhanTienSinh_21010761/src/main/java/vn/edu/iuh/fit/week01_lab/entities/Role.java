package vn.edu.iuh.fit.week01_lab.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "role_id", nullable = false, length = 50)
    private String roleId;

    @Column(name = "role_name", length = 50)
    private String roleName;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "account_id", length = 50)
    private String accountId;

    @Column(name = "login_time")
    private Instant loginTime;

    @Column(name = "logout_time")
    private Instant logoutTime;

    @Column(name = "note", length = 250)
    private String note;

}