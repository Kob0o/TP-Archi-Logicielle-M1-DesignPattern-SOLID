package org.example.tparchi26022026.exercice3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "org.example.exercice3.repository")
@EnableTransactionManagement
public class JpaConfig {
}
