package vn.edu.iuh.fit.week01_lab.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account")
@NamedQueries({
        @NamedQuery(
                name = "Account.findAccountByIdPassword",
                query = "select a from Account a where a.accountId = :account_id and a.password = :password"
        ),
        @NamedQuery(
                name = "Account.findAccountsByRole",
                query = "select a from Account a join GrantAccess ga on a.accountId = ga.account.accountId where ga.role.roleId = :role_id"
        ),
        @NamedQuery(name = "Account.findAll", query = "select a from Account a order by a.accountId"),
})
public class Account {
    @Id
    @Column(name = "account_id", nullable = false, length = 50)
    private String accountId;

    @Column(name = "full_name", length = 50)
    private String fullName;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "status", nullable = false)
    private Integer status;

}