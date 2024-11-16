package com.himanshu.esd_assignment.repo;

import com.himanshu.esd_assignment.dto.ProductResponse;
import com.himanshu.esd_assignment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findByProductName(String name);
}
