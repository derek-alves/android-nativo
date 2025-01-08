package com.composablecode.coroutinesflow.sections.coroutine_error

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineError {



    companion object{
        fun init(scope: LifecycleCoroutineScope){
            val handler = CoroutineExceptionHandler { context, exception ->
                exception.printStackTrace()
            }
            val coroutineScope = CoroutineScope(
                Dispatchers.Main.immediate + SupervisorJob()
                    )

            coroutineScope.launch(handler) {
                launch {
                    delay(1000L)
                    throw  Exception("ops!!!")
                }
                delay(2000L)
                println("Coroutine Finished")

            }

            coroutineScope.launch(handler) {
                delay(2000L)
                println("Coroutine Finished 2")

            }
        }
    }
}