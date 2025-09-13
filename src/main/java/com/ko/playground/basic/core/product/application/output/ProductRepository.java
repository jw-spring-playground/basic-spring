package com.ko.playground.basic.core.product.application.output;

import com.ko.playground.basic.core.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { }
