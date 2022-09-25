package com.metehanbolat.composestateandstateflowdifferences

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class MainViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _color = MutableStateFlow(0xFFFFFFFF)
    val color = _color.asStateFlow()

    val savedColor = savedStateHandle.getStateFlow("color", 0xFFFFFFFF)

    var composeColor by mutableStateOf(0xFFFFFFFF)
        private set

    var savedComposeColor by mutableStateOf(savedStateHandle.get<Long>("color") ?: 0xFFFFFFFF)
        private set

    fun generateRandomColor() {
        val color = Random.nextLong(0xFFFFFFFF)
        _color.value = color
        savedStateHandle["color"] = color
        composeColor = color
    }
}