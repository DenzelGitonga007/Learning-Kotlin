package com.example.alci.navigation

import android.graphics.pdf.content.PdfPageGotoLinkContent.Destination
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alci.ui.theme.screens.home.HomeScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_HOME

) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
//        Define the screens
//        HomeScreen
        composable(ROUTE_HOME) {
            HomeScreen(navController = navController)
        }
    }


}