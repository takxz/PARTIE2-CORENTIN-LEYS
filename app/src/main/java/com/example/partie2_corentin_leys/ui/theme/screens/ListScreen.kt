package com.example.partie2_corentin_leys.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.partie2_corentin_leys.viewmodel.TaskViewModel


@Composable
fun ListScreen(viewModel: TaskViewModel, navController: NavController) {
    val tasks = viewModel.userTask

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("add") }) {
                Icon(Icons.Default.Add, contentDescription = "Ajouter une tâche")
            }
        }
    ) {
        Column {
            Text(
                text = "Liste des tâches",
                fontWeight = FontWeight.Bold,
                )
        }
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(contentPadding = it) {
            items(tasks) { task ->
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                ){
                    Text(text = "${task.nom} - ${task.description} - ${task.priorite}")
                    HorizontalDivider(thickness = 1.dp, color = Color.Black)
                }
            }
        }
    }
}
