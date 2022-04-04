package com.example.cacheperftest.caches

import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable

open class SimpleCacheCache : AbstractCache {
    val set: MutableSet<String> = mutableSetOf()

    @CachePut(cacheNames = ["cache1"])
    override fun put(v: String) = true

    override fun freeze() {
    }

    @Cacheable(cacheNames = ["cache1"])
    override fun contains(v: String) = false

    @CacheEvict(cacheNames = ["cache1"])
    override fun evict() {
    }
}
