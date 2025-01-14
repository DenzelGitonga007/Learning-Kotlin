package com.example.sanctuaryoflove.ui.theme.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sanctuaryoflove.ui.theme.SanctuaryOfLoveTheme
import com.example.sanctuaryoflove.ui.theme.Sol_Blue


@Composable
fun WelcomeScreen(){
//    Vertical layout to arrange items in column
    Column(
        modifier = Modifier
            .fillMaxSize() // content to fill entire screen
            .padding(16.dp), // padding on the column
        horizontalAlignment = Alignment.CenterHorizontally, // position content horizontally centered
        verticalArrangement = Arrangement.Center, // vertically content center

    ) {
//        Text to display
        Text(
            text = "Welcome to Sanctuary of Love",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(24.dp)) // add space between elements

//         Button for about us
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(0.8f) // occupy 80% of the screen


            ) {

            Text( "About us")
        }

        Spacer(modifier = Modifier.height(16.dp))

//        Button for our services
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(0.8f) // occupy 80% of the screen
        ) {
            Text("Our services")
        }

        Spacer(modifier = Modifier.height(16.dp))

//        Button for contact us
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(0.8f) // occupy 80% of the screen
        ) {
            Text("Contact Us")
        }
    }

}


//The preview
@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview(){
    SanctuaryOfLoveTheme { 
        WelcomeScreen()
    }
}
