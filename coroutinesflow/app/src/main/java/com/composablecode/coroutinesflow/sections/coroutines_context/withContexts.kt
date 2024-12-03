package com.composablecode.coroutinesflow.sections.coroutines_context

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun withContextDemo(){
    println("Thread: ${Thread.currentThread().name}")

    withContext(Dispatchers.Main){
        println("Thread: ${Thread.currentThread().name}")

        withContext(Dispatchers.IO){
            println("Thread: ${Thread.currentThread().name}")
        }
    }
}