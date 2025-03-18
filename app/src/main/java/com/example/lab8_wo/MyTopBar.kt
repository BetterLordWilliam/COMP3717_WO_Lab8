package com.example.lab8_wo

import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

data class NavItem(val icon: ImageVector, val navRoute: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(navController: NavController, selectedColor: MutableState<Color>) {
    val homeItem = NavItem(Icons.Default.Home, "home")

    CenterAlignedTopAppBar(
        title = { Text("Colors") },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.navigate(homeItem.navRoute)
                }) {
                Icon(homeItem.icon, contentDescription = null)
            }
        },
        actions = {
            Icon(
                Icons.Default.Star,
                contentDescription = null,
                tint = selectedColor.value
            )
        }
    )
}