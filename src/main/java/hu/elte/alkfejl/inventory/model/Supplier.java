package hu.elte.alkfejl.inventory.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private String contact;

    @ManyToMany
    private List<Product> products;

    // @ManyToOne
    // private User owner;
}
