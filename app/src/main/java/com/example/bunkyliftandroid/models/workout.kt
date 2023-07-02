package com.example.bunkyliftandroid.models

import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class Workout(
    val name: String,
    val workoutId: Int,
    val exercises: List<Exercise>,
    val phase: String,
    val type: String,
    @SerialName("dateCompleted") val dateCompleted: String
)
