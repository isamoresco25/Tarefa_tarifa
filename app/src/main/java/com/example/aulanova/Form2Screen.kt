package com.example.aulanova

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Form2Screen(param: String?) {
    val navController = rememberNavController()
/*    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Green)) {

        Text(
            text = "Form2",
            textAlign = TextAlign.Center,
        )
        Text(
            text = "Nome: $param",
            textAlign = TextAlign.Center,
        )
    }*/
    Scaffold(
        bottomBar = {
            BottomNavigation() {
                BottomNavigationItem(
                    selected = true,
                    onClick = { navController.navigate("viagem") },
                    label = {
                        Text(text = "Viagem")
                    },
                    icon = {
                        Icon(Icons.Filled.Home, contentDescription = "")
                    }
                )
                BottomNavigationItem(
                    selected = true,
                    onClick = { navController.navigate("novo") },
                    label = {
                        Text(text = "Novo")
                    },
                    icon = {
                        Icon(Icons.Filled.Add, contentDescription = "")
                    }
                )
                BottomNavigationItem(
                    selected = true,
                    onClick = { navController.navigate("sobre") },
                    label = {
                        Text(text = "Sobre")
                    },
                    icon = {
                        Icon(Icons.Filled.AccountBox, contentDescription = "")
                    }
                )
            }
        }) {
        NavHost(navController = navController,
            startDestination = "viagem",
            modifier = Modifier.padding(paddingValues = it)
        ) {
            composable("viagem") {
                ListViagem()
            }
            composable("novo") {
                CadViagem()
            }
            composable("sobre") {
                Sobre()
            }
        }
    }
}