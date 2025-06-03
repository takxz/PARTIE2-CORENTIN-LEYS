package com.example.partie2_corentin_leys

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.partie2_corentin_leys.ui.theme.PARTIE2CORENTINLEYSTheme
import com.example.partie2_corentin_leys.viewmodel.TaskViewModel



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: TaskViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            PARTIE2CORENTINLEYSTheme {
                    AppNavHost(viewModel)
            }
        }
    }
}
