package com.composablecode.coroutinesflow.sections.coroutines_context

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun mainDispatcher(){
    withContext(Dispatchers.Main){

        withContext(Dispatchers.Main.immediate){

        }
    }
}