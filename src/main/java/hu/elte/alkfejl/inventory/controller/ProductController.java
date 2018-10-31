package hu.elte.alkfejl.inventory.controller;

import hu.elte.alkfejl.inventory.model.Product;
import hu.elte.alkfejl.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id) {
        Optional<Product> oProduct = productRepository.findById(id);
        if (oProduct.isPresent()) {
            return ResponseEntity.ok(oProduct.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        if (product.getId() != null && productRepository.existsById(product.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(productRepository.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replace(@PathVariable Integer id, @RequestBody Product product) {
        Optional<Product> oProduct = productRepository.findById(id);
        if (oProduct.isPresent()) {
            product.setId(oProduct.get().getId());
            return ResponseEntity.ok(productRepository.save(product));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> modify(@PathVariable Integer id, @RequestBody Product product) {
        Optional<Product> oProduct = productRepository.findById(id);
        if (oProduct.isPresent()) {
            Product modifiableProduct = oProduct.get();
            if (product.getName() != null) {
                modifiableProduct.setName((product.getName()));
            }
            if (product.getQuantity_in_stock() != null) {
                modifiableProduct.setQuantity_in_stock((product.getQuantity_in_stock()));
            }
            if (product.getSuppliers() != null) {
                modifiableProduct.setSuppliers((product.getSuppliers()));
            }
            return ResponseEntity.ok(productRepository.save(modifiableProduct));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Product> oProduct = productRepository.findById(id);
        if (oProduct.isPresent()) {
            productRepository.delete(oProduct.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
