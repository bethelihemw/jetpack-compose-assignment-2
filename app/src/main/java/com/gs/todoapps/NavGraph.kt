package com.gs.todoapps

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument

@Composable
fun AppNavGraph(viewModel: TodoViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "todo_list") {

        composable("todo_list") {
            TodoScreen(viewModel = viewModel, onItemClick = { todoId ->
                navController.navigate("todo_detail/$todoId")
            })
        }

        composable(
            route = "todo_detail/{todoId}",
            arguments = listOf(navArgument("todoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val todoId = backStackEntry.arguments?.getInt("todoId") ?: 0
            TodoDetailScreen(todoId = todoId, viewModel = viewModel)
        }
    }
}