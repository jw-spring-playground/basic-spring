package com.ko.playground.basic.core.productregistration.application.output;

import com.ko.playground.basic.core.productregistration.domain.ProductRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRegistrationRepository extends JpaRepository<ProductRegistration, Long> {

}
