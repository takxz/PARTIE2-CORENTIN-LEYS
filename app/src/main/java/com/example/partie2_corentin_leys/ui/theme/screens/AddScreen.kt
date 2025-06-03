package com.example.partie2_corentin_leys.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.partie2_corentin_leys.data.Priorite
import com.example.partie2_corentin_leys.viewmodel.TaskViewModel

@Composable
fun AddScreen(viewModel: TaskViewModel, navController: NavController) {
    var nom by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var priorite by remember { mutableStateOf(Priorite.Moyenne) }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = nom,
            onValueChange = { nom = it },
            label = { Text("Nom de la tâche") }
        )

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description de la tâche") }
        )

        DropdownMenuPriorite(priorite) { selected ->
            priorite = selected
        }

        Button(onClick = {
            viewModel.addAction(nom, description, priorite)
            navController.navigate("list")
        }) {
            Text("Ajouter")
        }
    }
}

@Composable
fun DropdownMenuPriorite(selected: Priorite, onPrioritySelected: (Priorite) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedButton(onClick = { expanded = true }) {
            Text(text = selected.name)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            Priorite.entries.forEach { p ->
                DropdownMenuItem(onClick = {
                    onPrioritySelected(p)
                    expanded = false
                }, text = { Text(p.name) })
            }
        }
    }
}
