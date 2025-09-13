package com.ko.playground.basic.core.product.application;

import com.ko.playground.basic.core.product.application.input.RegisterProduct;
import com.ko.playground.basic.core.product.application.input.command.RegisterProductCommand;
import com.ko.playground.basic.core.product.application.output.ProductRepository;
import com.ko.playground.basic.core.product.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService implements RegisterProduct {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public Product register(RegisterProductCommand command) {
        return productRepository.save(command.of());
    }
}
