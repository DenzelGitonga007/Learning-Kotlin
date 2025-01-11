package com.example.d_eats.ui.theme.screens.home


import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavController){


}



@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){

    HomeScreen(navController = rememberNavController())

}