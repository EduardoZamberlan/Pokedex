package com.example.azeredozamberlandejesus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.azeredozamberlandejesus.ui.theme.AzeredoZamberlanDeJesusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AzeredoZamberlanDeJesusTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Home()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(painterResource(R.drawable.ic_logo), "Uma imagem de uma Pokébola")
                        Text("Pokedex")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(R.drawable.ic_background_grass),
                    "Uma ilustração de um gramado"
                )
                Column {
                    Image(
                        painterResource(R.drawable.ic_bulbasaur), "Bulbasaur"
                    )
                    Text("Bulbasaur #0001", style = MaterialTheme.typography.titleLarge.copy(Color.White))
                }
            }
            Card(
                Modifier.padding(
                    horizontal = 24.dp,
                    vertical = 16.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Red
                )
            ) {
                Column(
                    Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text("8.5kg")
                            Image(painterResource(R.drawable.ic_rule), "Um ícone de um haltere de academia")
                            Text("Peso")
                        }
                    } //Fim da linha
                    Text("tipo", style = MaterialTheme.typography.titleLarge)
                    Row {
                        customAssistChip(
                            text = "Grama",
                            type = "grass"
                        )
                        customAssistChip(
                            text = "Veneno",
                            type = "poison"
                        )
                    }
                } //Fim da coluna
            } //Fim do card
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun customAssistChip(text: String, type: String) {
    ElevatedAssistChip(
        onClick = {},
        label = { Text(text) },
        colors = AssistChipDefaults.elevatedAssistChipColors(
            containerColor = chooseColor(type),
            labelColor = Color.White
        )
    )
}

fun chooseColor(type: String): Color {
    return when (type) {
        "grass" -> Color(0xFF9BCC50)
        "poison" -> Color(0xFFb97FC9)
        else -> Color.White
    }
}
