package com.example.cacheperftest

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.runApplication
import kotlin.system.measureTimeMillis

class CacheperftestApplication : CommandLineRunner {
    private var cache1: MemberListCache = Cache1()
    private var cache2: MemberListCache = Cache2()
    private var cache3: MemberListCache = Cache3()

    override fun run(vararg args: String?) {
        buildCacheData()
        test()
        resetCacheData()
        buildCacheData()
        test()
    }

    private fun resetCacheData() {
        this.cache1.evict()
        this.cache2.evict()
        this.cache3.evict()
    }

    private fun buildCacheData() {
        measureTimeMillis { this.cache1.build() }.also { println("build 1: $it") }
        measureTimeMillis { this.cache2.build() }.also { println("build 2: $it") }
        measureTimeMillis { this.cache3.build() }.also { println("build 3: $it") }
    }

    private fun test() {
        measureTimeMillis { this.cache1.test() }.also { println("test 1: $it") }
        measureTimeMillis { this.cache2.test() }.also { println("test 2: $it") }
        measureTimeMillis { this.cache3.test() }.also { println("test 3: $it") }
    }
}

fun main(args: Array<String>) {
    runApplication<CacheperftestApplication>(*args)
}

/**
 * 캐시 두개 만든다
 * 두개에 랜덤 데이터를 똑같이 생성해서 쭉 넣는다 1만개
 * 1. memberNo 를 캐시 키로 하는 캐시
 * 2. HashSet 을 캐시 키로 하는 캐시
 * 3. TreeSet 을 캐시 키로 하는 캐시
 *
 * 서로 다른 랜덤 키를 10만회 요청
 * 결과 확인
 */
