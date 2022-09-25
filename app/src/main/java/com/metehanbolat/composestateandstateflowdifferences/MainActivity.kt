package com.metehanbolat.composestateandstateflowdifferences

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.metehanbolat.composestateandstateflowdifferences.ui.theme.ComposeStateAndStateFlowDifferencesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStateAndStateFlowDifferencesTheme {

                val viewModel = viewModel<MainViewModel>()

                val composeColor = viewModel.composeColor
                val flowColor by viewModel.color.collectAsState()
                val savedFlowColor by viewModel.savedColor.collectAsState()
                val savedComposeColor = viewModel.savedComposeColor

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(savedComposeColor))
                        .clickable { viewModel.generateRandomColor() }
                )
            }
        }
    }
}
