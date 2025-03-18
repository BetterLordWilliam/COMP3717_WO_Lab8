package com.example.lab8_wo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Info(navController: NavController? = null, colorArgb: Int? = null) {
    // bad navigation
    if (colorArgb == null) {
        Text("Whoops, something went wrong!")
    }
    // good navigation
    else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(colorArgb))
        ) {
            // Show hex string of color in the center
            Text(
                String.format("%02x", colorArgb),
                fontSize = 25.sp,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}