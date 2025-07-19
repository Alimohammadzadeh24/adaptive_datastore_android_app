package com.alimmz.adaptive_datastore.data.entities_srializers

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.alimmz.adaptive_datastore.domain.entities.ThemePreference
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object ThemePreferenceSerializer : Serializer<ThemePreference> {

    override val defaultValue: ThemePreference = ThemePreference()

    override suspend fun readFrom(input: InputStream): ThemePreference {
        try {
            val text = input.readBytes().decodeToString()
            return Json.decodeFromString(ThemePreference.serializer(), text)
        } catch (exception: SerializationException) {
            throw CorruptionException("Cannot read ThemePreference", exception)
        }
    }

    override suspend fun writeTo(t: ThemePreference, output: OutputStream) {
        val jsonString = Json.encodeToString(ThemePreference.serializer(), t)
        output.write(jsonString.encodeToByteArray())
    }
} 