package keren.lint.puzzlegame.navigation

// NavGraph.kt
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import keren.lint.puzzlegame.screens.AchievementsScreen
import keren.lint.puzzlegame.screens.AchievementsViewModel
import keren.lint.puzzlegame.screens.CategoriesScreen
import keren.lint.puzzlegame.screens.HomeScreen
import keren.lint.puzzlegame.screens.PauseMenu
import keren.lint.puzzlegame.screens.PuzzleScreen
import keren.lint.puzzlegame.screens.PuzzleSelectionScreen
import keren.lint.puzzlegame.screens.SettingsScreen

@Composable
fun NavGraph(navController: NavHostController) {
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("puzzle_selection") { PuzzleSelectionScreen(navController) }
        composable("categories") { CategoriesScreen(navController) }
        composable("puzzle") { PuzzleScreen(navController) }
        composable("pause_menu") { PauseMenu(navController) }
        composable("settings") { SettingsScreen(navController) }
        composable("achievements") {
            val viewModel: AchievementsViewModel = viewModel()
            AchievementsScreen(navController, viewModel)
        }
    }
}