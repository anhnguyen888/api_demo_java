package com.hutech.demo.controller;

import com.hutech.demo.model.Product;
import com.hutech.demo.repository.ProductRepository;
import com.hutech.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/products")
public class ProductApiController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found on :: "
                        + id));
        return ResponseEntity.ok().body(product);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,
                                                 @RequestBody Product productData) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found on :: " + id));
        product.setName(productData.getName());
        product.setPrice(productData.getPrice());
        product.setDescription(productData.getDescription());
        final Product updatedProduct =productService.addProduct(product);
        return ResponseEntity.ok(updatedProduct);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found on :: "+ id));
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
}
