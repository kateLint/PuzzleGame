package keren.lint.puzzlegame.screens

// PuzzleScreen.kt
import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PuzzleScreen(navController: NavController) {
    val puzzlePieces = remember { mutableStateListOf<Offset>() } // Track piece positions
    val selectedPiece = remember { mutableStateOf<Offset?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Assemble the Puzzle") },
                actions = {
                    IconButton(onClick = { navController.navigate("pause_menu") }) {
                        Icon(Icons.Filled.Close, contentDescription = "Pause")
                    }
                }
            )
        }
    ) {
        Canvas(modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    selectedPiece.value = Offset(
                        selectedPiece.value?.x ?: 0f + dragAmount.x,
                        selectedPiece.value?.y ?: 0f + dragAmount.y
                    )
                }
            }) {
            puzzlePieces.forEach { piece ->
                drawRect(color = Color.Blue, topLeft = piece, size = Size(100f, 100f))
            }
            selectedPiece.value?.let {
                drawRect(color = Color.Red, topLeft = it, size = Size(100f, 100f))
            }
        }
    }
}
