package com.example.cacheperftest

import com.example.cacheperftest.caches.AbstractCache
import com.example.cacheperftest.caches.HashSetCache
import com.example.cacheperftest.caches.SimpleCacheCache
import com.example.cacheperftest.caches.SortedSetCache
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.runApplication
import kotlin.system.measureTimeMillis

class CacheperftestApplication : CommandLineRunner {
    private var simpleCacheCache: AbstractCache = SimpleCacheCache()
    private var hashSetCache: AbstractCache = HashSetCache()
    private var sortedSetCache: AbstractCache = SortedSetCache()

    override fun run(vararg args: String?) {
        buildCacheData()
        test()
        resetCacheData()
        buildCacheData()
        test()
        test()
        test()
        test()
    }

    private fun resetCacheData() {
        simpleCacheCache.evict()
        hashSetCache.evict()
        sortedSetCache.evict()
    }

    private fun buildCacheData() {
        println("-------")
        println("build 1: ${measureTimeMillis { simpleCacheCache.build() }}")
        println("build 2: ${measureTimeMillis { hashSetCache.build() }}")
        println("build 3: ${measureTimeMillis { sortedSetCache.build() }}")
    }

    private fun test() {
        println("-------")
        println("test 1: ${measureTimeMillis { simpleCacheCache.test() }}")
        println("test 2: ${measureTimeMillis { hashSetCache.test() }}")
        println("test 3: ${measureTimeMillis { sortedSetCache.test() }}")
    }
}

fun main(args: Array<String>) {
    runApplication<CacheperftestApplication>(*args)
}
