package com.ko.playground.basic.core.productregistration.application;

import com.ko.playground.basic.core.productregistration.application.input.RegisterProductRegistration;
import com.ko.playground.basic.core.productregistration.application.input.command.RegisterProductRegistrationCommand;
import com.ko.playground.basic.core.productregistration.application.output.ProductRegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductRegistrationService implements RegisterProductRegistration {
    private final ProductRegistrationRepository productRegistrationRepository;

    public ProductRegistrationService(ProductRegistrationRepository productRegistrationRepository) {
        this.productRegistrationRepository = productRegistrationRepository;
    }

    @Override
    public void register(RegisterProductRegistrationCommand command) {
        productRegistrationRepository.save(command.of());
    }
}
