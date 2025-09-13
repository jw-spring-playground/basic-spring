package com.ko.playground.basic.core.product.application.input;

import com.ko.playground.basic.core.product.application.input.command.RegisterProductCommand;
import com.ko.playground.basic.core.product.domain.Product;

public interface RegisterProduct {
    Product register(RegisterProductCommand command);
}
