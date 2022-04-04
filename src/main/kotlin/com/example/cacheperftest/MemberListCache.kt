package com.example.cacheperftest

interface MemberListCache {
    fun put(memberNo: Int)

    fun freeze()

    fun contains(memberNo: Int): Boolean

    fun evict()

    fun build() {
        for (i in 0..10000) {
            this.put(i)
        }
    }

    fun test() {
        for (i in 1..20000000) {
            contains(i)
            contains(i)
            contains(i)
        }
    }
}
