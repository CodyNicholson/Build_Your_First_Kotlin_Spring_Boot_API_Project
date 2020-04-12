package com.clairvoyantcoding.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestOperations
import org.springframework.web.client.RestTemplate

@Configuration
class RestConfig {
    @Bean
    fun restOperations(): RestOperations = RestTemplate()
}
