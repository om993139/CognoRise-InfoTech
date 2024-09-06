package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(navController: NavHostController, viewModel: CalculatorViewModel) {
    val historyList = viewModel.historyList.observeAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("History", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {
                    TextButton(onClick = { viewModel.clearHistory() }) {
                        Text("Clear History", color = Color.White , fontSize = 16.sp)
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Transparent
                ),
                        modifier = Modifier.background(
                        brush = Brush.horizontalGradient(
                            //colors = listOf(Color(0xFF667db6), Color(0xFF0082c8), Color(0xFF667db6))
                            colors = listOf(Color(0xFF833AB4), Color(0xFFFF4088), Color(0xFF92FE9D))

                        )
                        )
            )
        },
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()
            .padding(it)
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        //Color(0xFF00C9FF), // Light Blue
                        Color(0xFFFF4088),
                        Color(0xFF92FE9D), // Green
                        Color(0xFF38A3A5)  // Darker Cyan
                    )
                )
            )

        ) {
            if (historyList.value.isEmpty()) {
                Text(
                    text = "No History Available",
                    color = Color.White,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge
                )
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(historyList.value) { historyItem ->
                        Text(
                            text = historyItem,
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}
