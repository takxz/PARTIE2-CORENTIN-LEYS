package com.example.partie2_corentin_leys

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.partie2_corentin_leys.viewmodel.TaskViewModel
import com.example.partie2_corentin_leys.ui.theme.screens.AddScreen
import com.example.partie2_corentin_leys.ui.theme.screens.ListScreen


@Composable
fun AppNavHost(viewModel: TaskViewModel) {
    val navController = rememberNavController()

    Scaffold { padding ->
        NavHost(
            navController = navController,
            startDestination = "list",
            modifier = Modifier.padding(padding)
        ) {
            composable("add") { AddScreen(viewModel, navController) }
            composable("list") { ListScreen(viewModel, navController) }
        }
    }
}
