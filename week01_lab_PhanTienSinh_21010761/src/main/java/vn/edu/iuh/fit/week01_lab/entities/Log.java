package vn.edu.iuh.fit.week01_lab.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "account_id", nullable = false, length = 50)
    private String accountId;

    @ColumnDefault("current_timestamp()")
    @Column(name = "login_time", nullable = false)
    private Instant loginTime;

    @ColumnDefault("current_timestamp()")
    @Column(name = "logout_time", nullable = false)
    private Instant logoutTime;

    @ColumnDefault("''")
    @Column(name = "notes", nullable = false, length = 250)
    private String notes;

}