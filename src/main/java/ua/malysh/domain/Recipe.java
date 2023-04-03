package ua.malysh.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(
    name = "recipes", indexes = {
    @Index(name = "idx_recipe_id", columnList = "id")
}, uniqueConstraints = {
    @UniqueConstraint(name = "uc_recipe_name", columnNames = { "name" })
}
)
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients = new HashSet<>();
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null
            || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Recipe recipe = (Recipe) o;
        return getId() != null && Objects.equals(getId(), recipe.getId());
    }
    
    @OneToMany(mappedBy = "recipe")
    private Collection<Purchase> purchases;
    
    public Collection<Purchase> getPurchases() {
        return purchases;
    }
    
    public void setPurchases(Collection<Purchase> purchases) {
        this.purchases = purchases;
    }
}