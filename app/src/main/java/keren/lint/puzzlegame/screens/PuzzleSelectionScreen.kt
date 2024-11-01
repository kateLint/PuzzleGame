package keren.lint.puzzlegame.screens

// PuzzleSelectionScreen.kt
import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PuzzleSelectionScreen(navController: NavController) {
    val puzzles = listOf("Puzzle 1", "Puzzle 2", "Puzzle 3") // Sample data

    Scaffold(
        topBar = { TopAppBar(title = { Text("Select Puzzle") }) }
    ) {
        LazyColumn {
            items(puzzles) { puzzle ->
                ListItem(
                    headlineContent = { Text(puzzle) },
                    modifier = Modifier.clickable {
                        navController.navigate("puzzle") // Pass puzzle ID in a real app
                    }
                )
            }
        }
    }
}