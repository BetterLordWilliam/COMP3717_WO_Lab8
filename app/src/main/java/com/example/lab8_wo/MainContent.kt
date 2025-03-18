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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ColorCard() {
    Card (

    ) {
        Text("Color Card WOw!")
    }
}

@Composable
fun MainContent() {
    val navController = rememberNavController()
    val colorList = listOf(
        Color.Red,
        Color.Blue,
        Color.Cyan
    )

    var selectedColor = remember { mutableStateOf(Color.White) }

    Scaffold(
        topBar = { MyTopBar(navController, selectedColor) }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") {
                Home(navController)
            }
            composable("info/{key}") {
                val name = it.arguments?.getString("name")
                Info(navController, name)
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray)
        ) {
            item {
                ColorCard()
            }
        }
    }
}