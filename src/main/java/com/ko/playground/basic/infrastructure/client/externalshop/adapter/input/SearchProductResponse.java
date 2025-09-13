package com.ko.playground.basic.infrastructure.client.externalshop.adapter.input;

public record SearchProductResponse(
        Long price,
        Long remainingCount
) {
}
