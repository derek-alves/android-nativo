@file:OptIn(DelicateCoroutinesApi::class)

package com.composablecode.coroutinesflow.sections.coroutines_context

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

fun ioDefaultDispatcher() {
    val threads = hashMapOf<Long, String>()
    val job = GlobalScope.launch(Dispatchers.Default) {
        repeat(100) {
            launch {
                threads[Thread.currentThread().id] = Thread.currentThread().name

                Thread.sleep(1000L)
            }

        }
    }

    GlobalScope.launch {
        val time = measureTimeMillis {
            job.join()

        }
        println("Launched threads ${threads.keys.size} Time taken: $time")
    }
}