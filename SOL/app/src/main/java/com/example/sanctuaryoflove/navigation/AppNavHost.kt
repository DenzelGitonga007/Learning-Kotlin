package com.example.sanctuaryoflove.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sanctuaryoflove.ui.theme.screens.about.AboutScreen
import com.example.sanctuaryoflove.ui.theme.screens.home.HomeScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = ROUTE_HOME
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

//        Define the screens as by their routes
        composable(ROUTE_HOME) {
            HomeScreen(navController = navController)
        }

        composable(ROUTE_ABOUT) {
            AboutScreen(navController = navController)
        }




    }
}