package com.example.cacheperftest

import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableCaching
class CacheConfiguration {
    @Bean
    fun cacheManager(): CacheManager {
        return SimpleCacheManager()
    }
}
