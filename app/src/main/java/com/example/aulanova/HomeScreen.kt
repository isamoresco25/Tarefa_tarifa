package com.example.aulanova

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aulanova.R.string

@Composable
fun HomeScreen(onNavigateForm1: () -> Unit, onNavigateForm2: (nome: String) -> Unit) {
    val nome = remember {
        mutableStateOf("isa")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally) {
        TrabalhoScreen()
        Button(onClick = {onNavigateForm2(nome.value)}, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1E90FF)),) {
            Text(text = stringResource(string.botao_login), color = Color.White)
        }
        Text(
            text = "Cadastre-se",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )

        Button(onClick = {
            onNavigateForm1()
        }) {
            Text(text = "Realizar Cadastro")
        }
    }
    TrabalhoScreen()
}

@Composable
fun TrabalhoScreen() {

    Box(modifier = Modifier.fillMaxWidth()) {
        /*Image(
            painter = painterResource(id = com.example.aulanova.R.drawable.viagem),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )*/

        Column(
            modifier = Modifier

                .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Login()
        }
    }
}


@Composable
fun Login() {
    val usuario = remember {
        //lembrar da variavel
        mutableStateOf(value = "")
    }

    val senha = remember {
        //lembrar da variavel
        mutableStateOf(value = "")
    }

    Text(
        text = stringResource(id = com.example.aulanova.R.string.titulo),
        style = MaterialTheme.typography.h4,
        textAlign = TextAlign.Center,
        color = Color.Magenta,
    )

    Text(
        text = stringResource(id = com.example.aulanova.R.string.login),
        style = MaterialTheme.typography.h6,
        textAlign = TextAlign.Left,
        modifier = Modifier
    )

    OutlinedTextField(
        value = usuario.value,
        onValueChange = {

        },
        modifier = Modifier.width(400.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )

    Text(
        text = stringResource(id = com.example.aulanova.R.string.senha),
        style = MaterialTheme.typography.h6,
        textAlign = TextAlign.Start
    )

    OutlinedTextField(
        value = senha.value,
        onValueChange = {
            senha.value = it
        },
        modifier = Modifier.width(400.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )


    Text(text = usuario.value)
}
