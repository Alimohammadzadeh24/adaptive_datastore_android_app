package com.alimmz.adaptive_datastore.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class DailyHabitsList(
    val habits: List<DailyHabit> = emptyList()
)