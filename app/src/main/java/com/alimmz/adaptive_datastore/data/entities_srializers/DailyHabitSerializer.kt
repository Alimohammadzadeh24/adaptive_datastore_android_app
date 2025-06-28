package com.alimmz.adaptive_datastore.data.entities_srializers

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.alimmz.adaptive_datastore.domain.entities.DailyHabitsList
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream


object DailyHabitsListSerializer : Serializer<DailyHabitsList> {

    override val defaultValue: DailyHabitsList = DailyHabitsList()

    override suspend fun readFrom(input: InputStream): DailyHabitsList {
        try {
            val text = input.readBytes().decodeToString()
            return Json.decodeFromString(DailyHabitsList.serializer(), text)
        } catch (exception: SerializationException) {
            throw CorruptionException("Cannot read DailyHabitsList", exception)
        }
    }

    override suspend fun writeTo(t: DailyHabitsList, output: OutputStream) {
        val jsonString = Json.encodeToString(DailyHabitsList.serializer(), t)
        output.write(jsonString.encodeToByteArray())
    }
}
