package com.example.partie2_corentin_leys.data

enum class Priorite {
    Basse,
    Moyenne,
    Haute
}

data class Task(
    val nom: String,
    val description: String,
    val priorite: Priorite
)
