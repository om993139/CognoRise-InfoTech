package com.example.calculator

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculator.ui.theme.CalculatorTheme


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val calculatorViewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()
                    MainScreen(navController, calculatorViewModel )

                }
            }
        }
    }
}




@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun MainScreen(navController: NavHostController, viewModel: CalculatorViewModel) {
    NavHost(navController, startDestination = "calculator") {
        composable("calculator") { CalculatorScreen(navController = navController, viewModel = viewModel) }
        composable("history") { HistoryScreen(navController = navController, viewModel = viewModel) }
    }
}