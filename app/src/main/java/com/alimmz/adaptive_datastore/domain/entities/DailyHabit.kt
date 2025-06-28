package com.alimmz.adaptive_datastore.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class DailyHabit(
    val title: String,
    val description: String,
    val createdAt: String,
    val updatedAt: String,
    val isDone: Boolean
){
    companion object {
        fun getDefaultInstance(): DailyHabit {
            return DailyHabit(
                title = "",
                description = "",
                isDone = false,
                createdAt = "",
                updatedAt = "",
            )
        }
    }
}