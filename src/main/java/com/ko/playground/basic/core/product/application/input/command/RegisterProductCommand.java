package com.ko.playground.basic.core.product.application.input.command;

import com.ko.playground.basic.core.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterProductCommand {
    private String name;
    private String description;
    private Long price;

    public Product of() {
        return Product.create(name, price, description, 1L);
    }
}
