package ua.malysh.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(
    name = "products", indexes = {
    @Index(name = "idx_product_name", columnList = "name")
}, uniqueConstraints = {
    @UniqueConstraint(name = "uc_product_name", columnNames = { "name" })
}
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "measure", nullable = false)
    @Enumerated(EnumType.STRING)
    private Measure measure;
    
    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;
    
    @Column(name = "price")
    private BigDecimal price;
    
    @OneToOne(mappedBy = "product")
    private FridgeProduct fridgeProduct;
    
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    private Set<Ingredient> ingredients = new HashSet<>();
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null
            || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Product product = (Product) o;
        return getId() != null && Objects.equals(getId(), product.getId());
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
    @OneToMany(mappedBy = "product")
    private Collection<Purchase> purchase;
    
    public Collection<Purchase> getPurchase() {
        return purchase;
    }
    
    public void setPurchase(Collection<Purchase> purchase) {
        this.purchase = purchase;
    }
}