package com.example.calculator

import android.os.VibrationEffect
import android.os.Vibrator
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavHostController


@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreen(navController: NavHostController, viewModel: CalculatorViewModel) {
    val context = LocalContext.current
    val equationText = viewModel.equationText.observeAsState()
    val resultText = viewModel.resultText.observeAsState()



    var showMenu by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Calculator", color = Color.White, fontSize = 24.sp) },
                actions = {
                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Menu", tint = Color.White)
                    }
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("History") },
                            onClick = {
                                navController.navigate("history")
                                showMenu = false
                            }
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Transparent
                ),

                modifier = Modifier.background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF833AB4),
                            Color(0xFFFF4088),
                            //Color(0xFF92FE9D)
                            )


                    )
                )

            )
        },

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            //Color(0xFF00C9FF), // Light Blue
                            Color(0xFF833AB4),
                            Color(0xFFFF4088),
                            //Color(0xFF92FE9D), // Green
                            Color(0xFF38A3A5)  // Darker Cyan
                        )
                    )
                ),
            horizontalAlignment = Alignment.End
        ) {

            // Display Equation



            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.End
            ) {
                item {
                    Text(
                        text = equationText.value ?: "",
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.End,
                            color = Color.White
                        ),

                    )
                }

                item {
                    Spacer(modifier = Modifier.height(100.dp))
                    Text(
                        text = "${"="} ${resultText.value ?: ""}",
                        style = TextStyle(
                            fontSize = 40.sp,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.End,
                            color = Color.White
                        ),

                    )
                }
            }







            Spacer(modifier = Modifier.height(20.dp))

            // Calculator Buttons
            val buttonList = listOf(
                "DEL", "(", ")", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "AC", "0", ".", "="
            )
            LazyVerticalGrid(columns = GridCells.Fixed(4),
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                items(buttonList.size) { index ->
                    CalculatorButton(
                        btn = buttonList[index],
                        onClick = {
                            viewModel.onButtonClick(buttonList[index])
                            provideHapticFeedback(context)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(btn: String, onClick: () -> Unit) {
    Box(modifier = Modifier.padding(5.dp)) {
        FloatingActionButton(
            onClick = onClick,
            modifier = Modifier
                .size(80.dp)
                .graphicsLayer {
                    scaleX = 0.95f
                    scaleY = 0.95f
                },
            shape = CircleShape,
            containerColor = selectColor(btn),
            contentColor = Color.White
        ) {
            Text(
                text = btn,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Composable
fun selectColor(btn: String): Color {
    return when (btn) {
        "DEL", "AC" -> Color(0xFFF44336)
        "(", ")" -> Color.Gray
        "+", "-", "*", "/", "=" -> Color(0xFFFF9800)
        else -> Color(0xFFA5D6A7)
    }
}



// Lighter Vibration
@RequiresApi(Build.VERSION_CODES.Q)
fun provideHapticFeedback(context: Context) {
    val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (vibrator.hasVibrator()) {
        vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.EFFECT_TICK))
    }
}
