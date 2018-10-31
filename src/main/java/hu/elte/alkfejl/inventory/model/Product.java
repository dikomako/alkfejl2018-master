package hu.elte.alkfejl.inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private Integer quantity_in_stock;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Supplier> suppliers;
}
