package com.example.bunkyliftandroid.models

import kotlinx.serialization.*

import kotlinx.serialization.json.*

@Serializable
data class Exercise(
    val exerciseId: Int,
    val completed: String,
    val sets1: List<SetInfo>
)
