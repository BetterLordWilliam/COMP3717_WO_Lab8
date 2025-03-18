package com.example.lab8_wo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun Home(
    colorList: List<Color>,
    setColor: (color: Color) -> Unit,
    navController: NavController? = null
) {
    /**
     * Color card inner composable, it's inner because I didn't want to add a param...
     *
     * @param color Color       color that the card should have
     */
    @Composable
    fun ColorCard(color: Color) {
        Card (
            colors = CardDefaults.cardColors(
                containerColor = color
            ),
            // Use callback to set color state object
            onClick = {
                setColor(color)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(10.dp)
        ) {
            IconButton(
                // Navigate useing the nav controller object
                onClick = {
                    navController?.navigate("info/${color.toArgb()}")
                },
                modifier = Modifier
                    .align(Alignment.End)
            ) {
                Icon(
                    Icons.Outlined.Info,
                    "Wow info icon",
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }
    }

    // Lazy column to present the color cards
    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        items(colorList) { color: Color ->
            ColorCard(color)
        }
    }
}