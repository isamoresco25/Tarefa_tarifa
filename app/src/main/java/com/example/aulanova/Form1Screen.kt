package com.example.aulanova

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.aulanova.viewmodel.RegisterNewUserViewModel
import com.example.aulanova.viewmodel.RegisterNewUserViewModelFactory

@Composable
fun Form1Screen(onNavigateForm2: (nome: String) -> Unit, onBack: () -> Unit) {
    val application = LocalContext.current.applicationContext as Application
    val viewModel: RegisterNewUserViewModel = viewModel(
        factory = RegisterNewUserViewModelFactory(application)
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally){

        Text(
            text = "Realizar Cadastro",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4,
            color = Color.Magenta,
        )

        OutlinedTextField(value = viewModel.name,
            onValueChange = { viewModel.name = it},
            label = {
                Text(text = "Nome")
            }
        )
        OutlinedTextField(value = viewModel.email,
            onValueChange = {viewModel.email = it},
            label = {
                Text(text = "E-mail")
            }
        )
        OutlinedTextField(value = viewModel.password,
            onValueChange = {viewModel.password = it},
            label = {
                Text(text = "Password")
            }
        )

        Row() {
            Button(onClick = { onBack() }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1E90FF))) {
                Text(text = "Voltar")
            }

            Button(onClick = { viewModel.registrar() }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1E90FF))) {
                Text(text = "Salvar")
            }
        }
    }
}