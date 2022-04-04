package com.example.cacheperftest

class Cache2 : MemberListCache {
    private val cacheBuilder: MutableSet<Int> = mutableSetOf()
    private var set: Set<Int> = setOf()

    override fun put(memberNo: Int) {
        this.cacheBuilder.add(memberNo)
    }

    override fun freeze() {
        this.set = cacheBuilder.toHashSet()
        this.cacheBuilder.clear()
    }

    override fun contains(memberNo: Int): Boolean {
        return this.set.contains(memberNo)
    }

    override fun evict() {
    }
}
