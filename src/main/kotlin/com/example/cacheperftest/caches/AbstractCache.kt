package com.example.cacheperftest.caches

interface AbstractCache {
    fun put(v: String): Boolean

    fun freeze()

    fun contains(v: String): Boolean

    fun evict()

    fun build() {
        for (i in 20000000..20050000) {
            put(i.toString())
        }
    }

    fun test() {
        for (i in 20000000..30000000) {
            contains(i.toString())
            contains(i.toString())
            contains(i.toString())
        }
    }
}
