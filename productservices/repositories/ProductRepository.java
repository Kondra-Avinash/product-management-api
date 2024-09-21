package dev.avinash.productservices.repositories;

import dev.avinash.productservices.models.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product entity);

    Page<Product> findByTitleContaining(String title, Pageable pageable);
}
