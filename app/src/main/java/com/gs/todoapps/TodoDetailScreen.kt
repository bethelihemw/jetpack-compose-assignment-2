package com.gs.todoapps

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun TodoDetailScreen(todoId: Int, viewModel: TodoViewModel) {
    val todo = viewModel.todoList.collectAsState().value.find { it.id == todoId }

    todo?.let {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Text("Task ID: ${it.id}", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Title: ${it.title}", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Status: ${if (it.completed) "Completed ✅" else "Not Completed ❌"}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    } ?: run {
        Text("Task not found.", modifier = Modifier.padding(16.dp))
    }
}


//@Composable
//fun TodoDetailScreen(todoId: Int, viewModel: TodoViewModel) {
//    val todo = viewModel.todoList.collectAsState().value.find { it.id == todoId }
//
//    todo?.let {
//        Column(modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)) {
//            Text("ID: ${it.id}", style = MaterialTheme.typography.titleLarge)
//            Text("Title: ${it.title}", style = MaterialTheme.typography.titleMedium)
//            Text("Completed: ${if (it.completed) "✅" else "❌"}", style = MaterialTheme.typography.bodyMedium)
//        }
//    } ?: run {
//        Text("Todo not found", modifier = Modifier.padding(16.dp))
//    }
//}
//
