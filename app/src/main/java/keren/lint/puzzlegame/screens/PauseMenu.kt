package keren.lint.puzzlegame.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PauseMenu(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Paused") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {
            PauseMenuContent(navController)
        }
    )
}

@Composable
fun PauseMenuContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Game Paused",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = { navController.popBackStack() }, // Resumes the game by going back to the puzzle screen
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text("Resume")
        }

        Button(
            onClick = {
                navController.navigate("puzzle") {
                    popUpTo("puzzle") { inclusive = true }
                }
            }, // Restarts the current puzzle by navigating to the puzzle screen
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text("Restart")
        }

        Button(
            onClick = {
                navController.navigate("home") {
                    popUpTo("home") { inclusive = true }
                }
            }, // Returns to the home screen and clears the back stack
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
        ) {
            Text("Exit to Home", color = MaterialTheme.colorScheme.onError)
        }
    }
}