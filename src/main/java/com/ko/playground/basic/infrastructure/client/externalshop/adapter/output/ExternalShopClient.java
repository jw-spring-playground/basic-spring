package com.ko.playground.basic.infrastructure.client.externalshop.adapter.output;

import com.ko.playground.basic.infrastructure.client.externalshop.adapter.input.SearchProductRequest;
import com.ko.playground.basic.infrastructure.client.externalshop.adapter.input.SearchProductResponse;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ExternalShopClient {
    private final Random random = new Random();

    public SearchProductResponse searchProduct(SearchProductRequest request) {
        long price = 1000L + random.nextLong(9000L);
        long count = random.nextLong(50L);
        return new SearchProductResponse(price, count);
    }
}
