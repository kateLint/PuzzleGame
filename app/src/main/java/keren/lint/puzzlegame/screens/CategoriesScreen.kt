package keren.lint.puzzlegame.screens

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
@Composable
fun CategoriesScreen(navController: NavController) {
    val categories = listOf("Nature", "Animals", "Art") // Sample categories

    Scaffold(
        topBar = {
            @OptIn(ExperimentalMaterial3Api::class)
            TopAppBar(title = { Text("Categories") })
        }
    ) {
        LazyColumn {
            items(categories) { category ->
                ListItem(
                    headlineContent = { Text(category) },
                    modifier = Modifier.clickable {
                        navController.navigate("puzzle_selection") // Pass category ID in real app
                    }
                )
            }
        }
    }
}