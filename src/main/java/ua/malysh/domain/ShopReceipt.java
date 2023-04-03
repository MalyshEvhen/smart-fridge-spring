package ua.malysh.domain;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "shop_receipts", indexes = {
        @Index(name = "idx_shopreceipt_status", columnList = "status"),
        @Index(name = "idx_shopreceipt_session_id", columnList = "session_id")
})
public class ShopReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "sum", nullable = false)
    private BigDecimal sum;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "status", nullable = false)
    private Status status;

    @OneToMany(mappedBy = "shopReceipt", cascade = CascadeType.ALL)
    private Set<Purchase> purchases = new HashSet<>();

    public ShopReceipt(User user) {
        this.user = user;
    }

    public void addPurchases(List<Purchase> purchases) {
        this.purchases.addAll(purchases);
    }

    public void removePurchases(List<Purchase> purchases) {
        this.purchases.removeAll(purchases);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null
                || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        ShopReceipt that = (ShopReceipt) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}