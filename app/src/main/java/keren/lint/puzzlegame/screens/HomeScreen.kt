package keren.lint.puzzlegame.screens

// HomeScreen.kt
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import keren.lint.puzzlegame.R

/*@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Jigsaw Puzzle") }) }
    ) {
        Column {
            Button(onClick = { navController.navigate("puzzle_selection") }) {
                Text("Play")
            }
            Button(onClick = { navController.navigate("categories") }) {
                Text("Categories")
            }
            Button(onClick = { navController.navigate("settings") }) {
                Text("Settings")
            }
            Button(onClick = { navController.navigate("achievements") }) {
                Text("Achievements")
            }
        }
    }
}*/

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = {
            HomeScreenContent(navController)
        }
    )
}

@Composable
fun HomeScreenContent(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Background Image (optional)
        Image(
            painter = painterResource(id = R.drawable.bg_puzzle), // Replace with your actual background image resource
            contentDescription = "Background",
            contentScale = ContentScale.Crop, // Ensures the image fills the screen, cropping as needed
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Play Button (Primary Action)
            Button(
                onClick = { navController.navigate("puzzle_selection") },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(16.dp)
                    .shadow(4.dp, RoundedCornerShape(12.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Play", fontSize = 24.sp, color = Color.White)
            }

            // Categories Button
            OutlinedButton(
                onClick = { navController.navigate("categories") },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(vertical = 8.dp)
                    .shadow(2.dp, RoundedCornerShape(12.dp)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Categories", fontSize = 18.sp)
            }

            // Settings Button
            OutlinedButton(
                onClick = { navController.navigate("settings") },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(vertical = 8.dp)
                    .shadow(2.dp, RoundedCornerShape(12.dp)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Settings", fontSize = 18.sp)
            }

            // Achievements Button
            OutlinedButton(
                onClick = { navController.navigate("achievements") },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(vertical = 8.dp)
                    .shadow(2.dp, RoundedCornerShape(12.dp)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Achievements", fontSize = 18.sp)
            }
        }
    }
}