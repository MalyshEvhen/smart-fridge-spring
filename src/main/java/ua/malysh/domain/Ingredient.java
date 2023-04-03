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
    name = "ingredients", indexes = {
    @Index(name = "idx_ingredient_recipe_id", columnList = "recipe_id"),
    @Index(name = "idx_ingredient_product_id", columnList = "product_id")
}
)
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @ManyToOne(
        optional = false,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH
        }
    )
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    
    @ManyToOne(
        optional = false,
        cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH
        }
    )
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;
    
    @Column(name = "amount", nullable = false)
    private Double amount;
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null
            || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Ingredient that = (Ingredient) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}