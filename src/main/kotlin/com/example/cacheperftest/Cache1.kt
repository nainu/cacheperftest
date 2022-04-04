package com.example.cacheperftest

import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable

open class Cache1 : MemberListCache {
    val set: MutableSet<Int> = mutableSetOf()

    override fun put(memberNo: Int) {
        setAsMember(memberNo)
    }

    @CachePut(cacheNames = ["cache1"])
    open fun setAsMember(memberNo: Int) = true

    override fun freeze() {
    }

    @Cacheable(cacheNames = ["cache1"])
    override fun contains(memberNo: Int) = false

    @CacheEvict(cacheNames = ["cache1"])
    override fun evict() {
    }
}
