package com.example.bunkyliftandroid.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Card
import androidx.compose.material.Textimport androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bunkyliftandroid.models.Exercise
import com.example.bunkyliftandroid.models.Workout

@Composable
fun WorkoutCard(workout: Workout) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = workout.name, style = MaterialTheme.typography.h5)
            Text(text = "Type: ${workout.type}", style = MaterialTheme.typography.subtitle1)
            Text(text = "Phase: ${workout.phase}", style = MaterialTheme.typography.subtitle1)
            Text(text = "Completed: ${workout.dateCompleted}", style = MaterialTheme.typography.subtitle1)

            workout.exercises.forEach { exercise ->
                ExerciseCard(exercise = exercise)
            }
        }
    }
}

@Composable
fun ExerciseCard(exercise: Exercise) {
    val visibleState = remember { mutableStateOf(exercise.completed != "true") }
    AnimatedVisibility(
        visible = visibleState.value,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        Card(
            Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            elevation = 2.dp
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Exercise ${exercise.exerciseId}")
                exercise.sets1.forEach { setInfo ->
                    Text("Rep ${setInfo.repNumb}, weight: ${setInfo.weight}, effort: ${setInfo.effort}")
                    Text("Note: ${setInfo.note}")
                }
                Button(onClick = { visibleState.value = false }) {
                    Text("Mark as Completed")
                }
            }
        }
    }
}