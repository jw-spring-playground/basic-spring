package com.ko.playground.basic.infrastructure.client.externalshop.adapter;

import com.ko.playground.basic.infrastructure.client.externalshop.adapter.input.SearchProduct;
import com.ko.playground.basic.infrastructure.client.externalshop.adapter.input.SearchProductRequest;
import com.ko.playground.basic.infrastructure.client.externalshop.adapter.input.SearchProductResponse;
import com.ko.playground.basic.infrastructure.client.externalshop.adapter.output.ExternalShopClient;
import org.springframework.stereotype.Service;

@Service
public class ExternalShopService implements SearchProduct {
    private final ExternalShopClient externalShopClient;

    public ExternalShopService(ExternalShopClient externalShopClient) {
        this.externalShopClient = externalShopClient;
    }

    @Override
    public SearchProductResponse search(SearchProductRequest request) {
        return externalShopClient.searchProduct(request);
    }
}
