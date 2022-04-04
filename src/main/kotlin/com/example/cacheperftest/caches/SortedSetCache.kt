package com.example.cacheperftest.caches

class SortedSetCache : AbstractCache {
    private val cacheBuilder: MutableSet<String> = mutableSetOf()
    private var set: Set<String> = setOf()

    override fun put(v: String): Boolean {
        cacheBuilder.add(v)
        return true
    }

    override fun freeze() {
        set = cacheBuilder.toSortedSet()
        cacheBuilder.clear()
    }

    override fun contains(v: String): Boolean {
        return set.contains(v)
    }

    override fun evict() {
    }
}
