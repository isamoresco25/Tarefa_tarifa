package com.example.aulanova

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CadViagem() {
    val lugar = remember {
        mutableStateOf("")
    }

    val data_inicio = remember {
        mutableStateOf(value = "")
    }

    val data_fim = remember {
        mutableStateOf(value = "")
    }
    val orcamento = remember {
        mutableStateOf(value = "")
    }
    val tipo_viagem = remember {
        mutableStateOf(value = "")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally){

        Text(
            text = "Cadastrar Nova Viagem",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4,
            color = Color.Magenta,
        )

        Text(
            text = stringResource(id = R.string.tit_destino),
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Start
        )

        OutlinedTextField(
            value = lugar.value,
            onValueChange = {
                lugar.value = it
            },
            modifier = Modifier.width(350.dp),
        )

        Text(
            text = stringResource(id = R.string.tit_data_inicio),
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Start
        )

        OutlinedTextField(value = data_inicio.value,
            onValueChange = {
                data_inicio.value = it
            },
            modifier = Modifier.width(350.dp),

            )

        Text(
            text = stringResource(id = R.string.tit_data_fim),
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Start
        )

        OutlinedTextField(value = data_fim.value,
            onValueChange = {
                data_fim.value = it
            },
            modifier = Modifier.width(350.dp),)
        Text(
            text = stringResource(id = R.string.tit_orcamento),
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Start
        )

        OutlinedTextField(value = orcamento.value,
            onValueChange = {
                orcamento.value = it
            },
            modifier = Modifier.width(350.dp),)
            Button(onClick = {}, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1E90FF)),) {
            Text(text = stringResource(R.string.botao_nova_viagem), color = Color.White)
        }
    }
}