package hu.elte.alkfejl.inventory.repository;

import hu.elte.alkfejl.inventory.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
