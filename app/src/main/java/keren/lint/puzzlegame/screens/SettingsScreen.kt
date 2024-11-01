package keren.lint.puzzlegame.screens

// SettingsScreen.kt
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsScreen(navController: NavController) {
    var soundEnabled by remember { mutableStateOf(true) }
    var rotationEnabled by remember { mutableStateOf(true) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Settings") }) }
    ) {
        Column {
            Row {
                Text("Sound")
                Switch(checked = soundEnabled, onCheckedChange = { soundEnabled = it })
            }
            Row {
                Text("Rotation")
                Switch(checked = rotationEnabled, onCheckedChange = { rotationEnabled = it })
            }
            Button(onClick = { navController.popBackStack() }) {
                Text("Save")
            }
        }
    }
}
