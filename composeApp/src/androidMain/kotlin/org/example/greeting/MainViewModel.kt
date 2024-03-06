package org.example.greeting

import Greeting
import RocketRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class MainViewModel : ViewModel() {
    private val rocketRepository: RocketRepository by inject(RocketRepository::class.java)
    private val _greetingList = MutableStateFlow<List<String>>(listOf())
    val greetingList: StateFlow<List<String>> get() = _greetingList

    init {
        viewModelScope.launch {
            Greeting(rocketRepository).greet().collect { phrase ->
                _greetingList.update { list -> list + phrase }
            }
        }
    }
}