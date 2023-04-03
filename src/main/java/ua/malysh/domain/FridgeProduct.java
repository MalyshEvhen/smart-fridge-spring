package ua.malysh.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(
    name = "fridge_products", indexes = {
    @Index(name = "idx_fridgeproduct_product_id", columnList = "product_id")
}, uniqueConstraints = {
    @UniqueConstraint(
        name = "uc_fridgeproduct_product_id",
        columnNames = { "product_id" }
    )
}
)
public class FridgeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    
    @Column(name = "amount", nullable = false)
    private Double amount;
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null
            || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        FridgeProduct that = (FridgeProduct) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}