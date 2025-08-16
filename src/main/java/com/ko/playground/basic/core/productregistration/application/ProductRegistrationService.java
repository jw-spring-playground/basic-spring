package com.ko.playground.basic.core.productregistration.application;

import com.ko.playground.basic.core.productregistration.application.input.AllowedProductRegistration;
import com.ko.playground.basic.core.productregistration.application.input.RequestProductRegistration;
import com.ko.playground.basic.core.productregistration.application.input.command.AllowedProductRegistrationCommand;
import com.ko.playground.basic.core.productregistration.application.input.command.RequestProductRegistrationCommand;
import com.ko.playground.basic.core.productregistration.application.output.ProductRegistrationRepository;
import com.ko.playground.basic.core.productregistration.domain.ProductRegistration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductRegistrationService implements RequestProductRegistration, AllowedProductRegistration {
    private final ProductRegistrationRepository productRegistrationRepository;

    public ProductRegistrationService(ProductRegistrationRepository productRegistrationRepository) {
        this.productRegistrationRepository = productRegistrationRepository;
    }

    @Override
    public void register(RequestProductRegistrationCommand command) {
        productRegistrationRepository.save(command.of());
    }

    @Transactional
    @Override
    public void allowed(AllowedProductRegistrationCommand command) {
        ProductRegistration productRegistration = productRegistrationRepository.findById(command.productRegistrationId()).orElseThrow();
        productRegistration.register();
    }
}
