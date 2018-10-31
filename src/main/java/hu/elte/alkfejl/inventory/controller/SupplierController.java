package hu.elte.alkfejl.inventory.controller;

import hu.elte.alkfejl.inventory.model.Product;
import hu.elte.alkfejl.inventory.model.Supplier;
import hu.elte.alkfejl.inventory.repository.SupplierRepository;
import hu.elte.alkfejl.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/suppliers")
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
public class SupplierController {

    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public Iterable<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> get(@PathVariable Integer id) {
        Optional<Supplier> oSupplier = supplierRepository.findById(id);
        if (oSupplier.isPresent()) {
            return ResponseEntity.ok(oSupplier.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Supplier> create(@RequestBody Supplier supplier) {
        if (supplier.getId() != null && supplierRepository.existsById(supplier.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(supplierRepository.save(supplier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Supplier> oSupplier = supplierRepository.findById(id);
        if (oSupplier.isPresent()) {
            supplierRepository.delete(oSupplier.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/songs")
    public ResponseEntity<List<Product>> addSong(@PathVariable Integer id, @RequestBody Product product) {
        Optional<Supplier> oSupplier = supplierRepository.findById(id);
        Optional<Product> oProduct = productRepository.findById(product.getId());
        if (oSupplier.isPresent() && oProduct.isPresent()) {
            Supplier supplier = oSupplier.get();
            supplier.getProducts().add(oProduct.get());
            supplierRepository.save(supplier);
            return ResponseEntity.ok(supplier.getProducts());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{supplierId}/products/{productId}")
    public ResponseEntity removeSong(@PathVariable Integer supplierId,
                                     @PathVariable Integer productId) {
        Optional<Supplier> oSupplier = supplierRepository.findById(supplierId);
        if (oSupplier.isPresent()) {
            Supplier supplier = oSupplier.get();
            Optional<Product> oProduct = supplier.getProducts().stream()
                    .filter(product -> product.getId() == productId)
                    .findFirst();
            if (oProduct.isPresent()) {
                List<Product> filteredProducts = supplier.getProducts().stream()
                        .filter(product -> product.getId() != productId)
                        .collect(Collectors.toList());
                supplier.setProducts(filteredProducts);
                supplierRepository.save(supplier);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
