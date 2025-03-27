package com.ko.playground.basic.config.database.mysql;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.ko.playground.basic.core")
@EntityScan(basePackages = "com.ko.playground.basic.core")
@Configuration
public class JpaConfig {}
