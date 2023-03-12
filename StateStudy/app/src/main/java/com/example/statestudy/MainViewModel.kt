package com.example.statestudy

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel : ViewModel() {

    private val _stateFlow = MutableStateFlow(0)
    val counter = _stateFlow.asStateFlow()


    private val _color = MutableStateFlow(0xffffffff)
    val color = _color.asStateFlow()


    var composeColor by mutableStateOf(0xffffffff)
        private set

    fun generateNewColor() {
        val color = Random.nextLong(0xffffffff)
        _color.value = color
        composeColor = color
    }

    fun incrementCounter(){
        _stateFlow.value +=1
    }

    val countDownFlow = flow<Int> {
        val startingValue = 5
        var currentValue = startingValue
        emit(startingValue)
        while (currentValue > 0) {
            delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }

    init {
        collectFlow()
    }


    @OptIn(FlowPreview::class)
    private fun twoFlows() {
        val flow1 = flow {
            emit(1)
            delay(500L)
            emit(2)
        }



        viewModelScope.launch {
            flow1.flatMapConcat { value ->
                flow {
                    emit(value + 1)
                    delay(500L)
                    emit(value + 2)
                }
            }.collect { value ->
                println("The value is $value")
            }
        }
    }

    private fun collectFlow() {
//        countDownFlow.onEach {
//            println(it)
//        }.launchIn(viewModelScope)

        viewModelScope.launch {
            val count = countDownFlow.filter { time ->
                time % 0 == 0
            }.map { time ->
                time * time
            }.onEach { time ->
                println(time)
            }.count { time ->
                time % 0 == 0
            }
            println("The count is $count")
        }
    }


    @OptIn(FlowPreview::class)
    private fun restaurantCall() {
        val flow = flow {
            delay(250L)
            emit("Appetizer")
            delay(1000L)
            emit("Main dish")
            delay(100L)
            emit("Dessert")
        }
        viewModelScope.launch {
            flow.onEach {
                println("FLOW: $it is delivered")
            }.buffer().collectLatest {
                println("FLOW: Now eating $it")
                delay(1500L)
                println("FLOW: Finished eating $it")
            }
        }
    }
}


