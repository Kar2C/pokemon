package com.example.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemon.ui.theme.PokemonTheme

@OptIn(ExperimentalMaterial3Api::class) // Añadimos esta línea para la API experimental
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonTheme {
                PokedexScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class) // Añadimos esta línea para la API experimental
@Composable
fun PokedexScreen() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            SearchBar()
            PokemonGrid()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF44336)) // Color rojo estilo Pokédex
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icon(
            //painter = painterResource(id = R.drawable.ic_pokeball), // Icono de Pokebola
            //contentDescription = "Pokeball",
        //modifier = Modifier.padding(end = 8.dp)
        //)
        Text(
            text = "Pokedex",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.weight(1f)
        )
        //Icon(
          //  painter = painterResource(id = R.drawable.ic_menu), // Icono de menú
            //contentDescription = "Menu",
            //modifier = Modifier.padding(start = 8.dp)
        //)
    }
}

@Composable
fun SearchBar() {
    val searchText = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFFEEEEEE), CircleShape)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        BasicTextField(
            value = searchText.value,
            onValueChange = { searchText.value = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            textStyle = TextStyle(fontSize = 18.sp, color = Color.Black)
        )
    }
}

@Composable
fun PokemonGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.padding(8.dp)
    ) {
        items(12) { index -> // Cambiar por la cantidad de Pokémon
            Box(
                modifier = Modifier
                    .aspectRatio(1f)
                    .padding(4.dp)
                    .background(Color.Gray)
            )
        }
    }
}

@Composable
fun BottomNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF44336)) // Color rojo estilo Pokédex
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* Acción de Home */ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = "Home",
                tint = Color.White
            )
        }
        IconButton(onClick = { /* Acción de Favoritos */ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_favorite),
                contentDescription = "Favoritos",
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokedexScreenPreview() {
    PokemonTheme {
        PokedexScreen()
    }
}
