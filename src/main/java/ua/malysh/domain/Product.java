package ua.malysh.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.Hibernate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "products", indexes = {
        @Index(name = "idx_products_name", columnList = "name")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uc_products_name", columnNames = { "name" })
})
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

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    private Set<Ingredient> ingredients = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public FridgeProduct getFridgeProduct() {
        return fridgeProduct;
    }

    public void setFridgeProduct(FridgeProduct fridgeProduct) {
        this.fridgeProduct = fridgeProduct;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    @OneToMany(mappedBy = "product")
    private Collection<Purchase> purchase;

    public Collection<Purchase> getPurchase() {
        return purchase;
    }

    public void setPurchase(Collection<Purchase> purchase) {
        this.purchase = purchase;
    }

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
}