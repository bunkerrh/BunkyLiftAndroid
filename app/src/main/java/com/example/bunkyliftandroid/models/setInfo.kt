package com.example.bunkyliftandroid.models

import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class SetInfo(
    @SerialName("repNumb") val repNumb: Int,
    val weight: Int,
    val effort: Int,
    val note: String
)
