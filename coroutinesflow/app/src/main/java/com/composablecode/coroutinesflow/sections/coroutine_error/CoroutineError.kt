package com.composablecode.coroutinesflow.sections.coroutine_error

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineError {



    companion object{
        fun init(scope: LifecycleCoroutineScope){
            val handler = CoroutineExceptionHandler { context, exception ->
                exception.printStackTrace()
            }

            scope.launch(handler) {
                launch {
                    delay(1000L)
                    throw  Exception("ops!!!")
                }
                delay(2000L)
                println("Coroutine Finished")

            }
        }
    }
}