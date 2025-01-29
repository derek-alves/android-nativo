package com.composablecode.coroutinesflow.sections.concurrMutex

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.concurrent.ConcurrentHashMap
import kotlin.random.Random

fun synchronizationDemo() {
    val normalHashMap = hashMapOf<Int,Int>()
    val concurrentHashMap = ConcurrentHashMap<Int,Int>()
    val concurrentHashMap2 = ConcurrentHashMap<Int,Int>()

    val mutex1 = Mutex()
    val mutex2 = Mutex()
    val mutex3 = Mutex()

    GlobalScope.launch(Dispatchers.IO.limitedParallelism(1)) {
        (1..10000).map {
            launch {
                val random = Random.nextInt(1,9)
                mutex1.withLock {
                    val concurrentValue = concurrentHashMap[random] ?:0
                    concurrentHashMap[random] = concurrentValue + 1
                }
                mutex2.withLock {
                    val concurrentValue2 = concurrentHashMap2[random] ?:0
                    concurrentHashMap2[random] = concurrentValue2 + 1
                }
                mutex1.withLock {
                    val concurrentNormalValue = normalHashMap[random] ?:0
                    normalHashMap[random] = concurrentNormalValue + 1
                }
            }
        }.joinAll()
    }
}