package hu.elte.alkfejl.inventory.repository;

import hu.elte.alkfejl.inventory.model.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends CrudRepository<Supplier, Integer> {
}
