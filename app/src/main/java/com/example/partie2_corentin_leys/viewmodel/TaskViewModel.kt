package com.example.partie2_corentin_leys.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.partie2_corentin_leys.data.Priorite
import com.example.partie2_corentin_leys.data.Task

class TaskViewModel : ViewModel() {
    private val _userTask = mutableStateListOf<Task>()
    val userTask: List<Task> = _userTask

    fun addAction(nom: String, description: String, priorite: Priorite) {
        val newTask = Task(nom = nom, description = description, priorite = priorite)
        _userTask.add(newTask)
    }
}
