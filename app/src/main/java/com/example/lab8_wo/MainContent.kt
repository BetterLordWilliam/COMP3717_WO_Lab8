package com.example.lab8_wo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainContent() {
    val navController = rememberNavController()
    // Color list
    val colorList = listOf(
        Color(0xFFF44336),
        Color(0xFFE91E63),
        Color(0xFF9C27B0),
        Color(0xFF3F51B5),
        Color(0xFF2196F3),
        Color(0xFF009688),
        Color(0xFF4CAF50),
        Color(0xFFFFEB3B)
    )
    // Selected color state object
    var selectedColor by remember { mutableStateOf(Color.White) }

    // Main content scaffold
    Scaffold(
        topBar = { MyTopBar(navController, selectedColor) }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier
                .padding(padding)
        ) {
            // Home composable defined w/ route
            composable("home") {
                Home(colorList, { color: Color ->
                    selectedColor = color
                }, navController)
            }
            // Info composable defined w/ route and params
            composable("info/{colorArgb}") {
                val colorArgb = it.arguments?.getString("colorArgb")?.toInt()
                Info(navController, colorArgb)
            }
        }
    }
}