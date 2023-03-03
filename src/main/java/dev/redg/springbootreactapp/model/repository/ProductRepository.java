package dev.redg.springbootreactapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.redg.springbootreactapp.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
