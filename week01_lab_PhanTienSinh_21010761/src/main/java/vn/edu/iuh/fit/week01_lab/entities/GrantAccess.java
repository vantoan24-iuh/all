package vn.edu.iuh.fit.week01_lab.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "grant_access")
@NamedQueries(
        {
                @NamedQuery(
                        name = "GrantAccess.findAll",
                        query = "select ga from GrantAccess ga"
                ),
                @NamedQuery(
                        name = "GrantAccess.findGrantAccessByAccountId",
                        query = "select ga from GrantAccess ga where ga.account.accountId = :account_id"
                ),
                @NamedQuery(
                        name = "GrantAccess.findGrantAccessByRoleId",
                        query = "select ga from GrantAccess ga where ga.role.roleId = :role_id"
                )
        }
)
public class GrantAccess {
    @EmbeddedId
    private GrantAccessId id;

    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @MapsId("accountId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "is_grant")
    private Byte isGrant;

    @ColumnDefault("''")
    @Column(name = "note", length = 250)
    private String note;

}