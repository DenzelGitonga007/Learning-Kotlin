package com.example.d_eats.ui.theme.screens.Menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.d_eats.R
import com.example.d_eats.data.MenuViewModel
import com.example.d_eats.models.Menu
import com.example.d_eats.navigation.ROUTE_ABOUT
import com.example.d_eats.navigation.ROUTE_HOME
import com.example.d_eats.ui.theme.LightCyan
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ViewMenuScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val context = LocalContext.current
        val taskRepository = MenuViewModel(navController, context)


        val emptyTaskState = remember { mutableStateOf(Menu("","","","","","")) }
        val emptyTasksListState = remember { mutableStateListOf<Menu>() }

        val tasks = taskRepository.allMenu(emptyTaskState, emptyTasksListState)

        Column (
            modifier = Modifier.padding(horizontal = 12.dp)
        ){

            Spacer(modifier = Modifier.height(30.dp))
            // home icon
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    modifier = Modifier.clickable { navController.navigate(ROUTE_HOME) },
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Home",
                    modifier = Modifier.clickable { navController.navigate(ROUTE_HOME) },
                    fontWeight = FontWeight.SemiBold
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            navController.navigate(ROUTE_ABOUT)
                        }
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Help",
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.clickable {
                            navController.navigate(ROUTE_ABOUT)
                        }
                    )
                }
            }
            //end of home icon
            //intro row
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                //card holding icon
                Card (
                    modifier = Modifier
                        .size(70.dp),
                    shape = RoundedCornerShape(50)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.register),
                        contentDescription = "top icon",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(6.dp)
                    )
                }
                //end of card holding icon

            }
            Text(
                text = "View Menus",
                fontSize = 26.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif
            )
            // intro row end

            Spacer(modifier = Modifier.height(15.dp))

            val currentUser = FirebaseAuth.getInstance().currentUser
            val currentUserId = currentUser?.uid

            LazyColumn(){
                items(tasks){
                    if (it.userId == currentUserId){
                        TaskItem(
                            name = it.name,
                            description = it.description,
                           quantity = it.quantity,
                           price = it.price,
                            id = it.id,
                            userId = it.userId,
                            navController = navController,
                            taskRepository = taskRepository
                        )
                    }

                }
            }

        }
    }
}

@Composable
fun TaskItem(
    name:String, description:String,quantity:String, price:String, id:String, userId:String,
    navController: NavHostController,
    taskRepository: MenuViewModel
){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 25.dp)
    ){
        Card (
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                Color.LightGray
            )
        ){
            Column (
                modifier = Modifier.padding(8.dp)
            ){
                Text(
                    text = "Meal: $name",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textDecoration = TextDecoration.Underline
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "Description : $description",
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "Quantity : $quantity",
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "Amount per plata : $price",
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(3.dp))

                //button row
                Row (
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    OutlinedButton(
                        onClick = {
                            taskRepository.updateMenu(id)
                        },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(LightCyan)

                        ) {
                        Row {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "update"
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Text(
                                text = "Update"
                            )
                        }
                    }
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ){
                        Button(
                            onClick = {
                                taskRepository.deleteMenu(id)
                            },
                            colors = ButtonDefaults.buttonColors(
                                Color.Red
                            ),
                            shape = RoundedCornerShape(8.dp),
//                            colors = ButtonDefaults.buttonColors(Color.Red)

                        ) {
                            Row {
                                Icon(imageVector = Icons.Default.Delete, contentDescription = "delete")
                                Spacer(modifier = Modifier.width(3.dp))
                                Text(
                                    text = "Delete",
                                    color = Color.White
                                )
                            }
                        }
                    }

                }
                //end of button row
            }
        }

    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ViewMenuScreenPreview(){
    ViewMenuScreen(navController = rememberNavController())
}