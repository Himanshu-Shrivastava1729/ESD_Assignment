package com.himanshu.esd_assignment.controller;


import com.himanshu.esd_assignment.dto.ProductRequest;
import com.himanshu.esd_assignment.dto.ProductResponse;
import com.himanshu.esd_assignment.entity.Product;
import com.himanshu.esd_assignment.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/{pname}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable String pname) {
        return  ResponseEntity.ok(productService.retrieveProduct(pname));
    }

    @PostMapping("/")
    public ResponseEntity<String> createProduct(@RequestBody @Valid ProductRequest request) {
        String res = productService.createProduct(request);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{pid}")
    public ResponseEntity<String> deleteProduct(@PathVariable int pid) {
        String res = productService.deleteProduct(pid);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/")
    public ResponseEntity<String> updateProduct(@RequestBody ProductRequest request) {
        String res = productService.updateProduct(request);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> searchByPrice()
    {
        List<Product> res = productService.searchByPrice();
        System.out.println(res);
        return ResponseEntity.ok(res);
    }
}
