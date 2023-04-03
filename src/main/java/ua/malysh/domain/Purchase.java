package ua.malysh.domain;

import java.math.BigDecimal;
import java.util.Objects;

import org.hibernate.Hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shop_receipt_id")
    private ShopReceipt shopReceipt;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    public Purchase(
            Product product,
            Recipe recipe,
            ShopReceipt shopReceipt,
            Double amount,
            BigDecimal productPrice) {
        this.product = product;
        this.recipe = recipe;
        this.shopReceipt = shopReceipt;
        this.amount = amount;
        this.productPrice = productPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public ShopReceipt getShopReceipt() {
        return shopReceipt;
    }

    public void setShopReceipt(ShopReceipt shopReceipt) {
        this.shopReceipt = shopReceipt;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null
                || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Purchase purchase = (Purchase) o;
        return getId() != null && Objects.equals(getId(), purchase.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}