package com.alimmz.adaptive_datastore.data.injection

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import com.alimmz.adaptive_datastore.data.entities_srializers.DailyHabitsListSerializer
import com.alimmz.adaptive_datastore.data.entities_srializers.ThemePreferenceSerializer
import com.alimmz.adaptive_datastore.data.source.DailyHabitLocalDataSource
import com.alimmz.adaptive_datastore.data.source.DailyHabitLocalDataSourceImpl
import com.alimmz.adaptive_datastore.data.source.ThemeLocalDataSource
import com.alimmz.adaptive_datastore.data.source.ThemeLocalDataSourceImpl
import com.alimmz.adaptive_datastore.domain.entities.DailyHabitsList
import com.alimmz.adaptive_datastore.domain.entities.ThemePreference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideDailyHabitsDataStore(
        @ApplicationContext context: Context
    ): DataStore<DailyHabitsList> = DataStoreFactory.create(
        serializer = DailyHabitsListSerializer,
        produceFile = { File(context.filesDir, "daily_habits.json") }
    )

    @Provides
    @Singleton
    fun provideThemePreferenceDataStore(
        @ApplicationContext context: Context
    ): DataStore<ThemePreference> = DataStoreFactory.create(
        serializer = ThemePreferenceSerializer,
        produceFile = { File(context.filesDir, "theme_preference.json") }
    )

    @Provides
    @Singleton
    fun provideDailyHabitLocalDataSource(
        dataStore: DataStore<DailyHabitsList>
    ): DailyHabitLocalDataSource {
        return DailyHabitLocalDataSourceImpl(dataStore)
    }

    @Provides
    @Singleton
    fun provideThemeLocalDataSource(
        dataStore: DataStore<ThemePreference>
    ): ThemeLocalDataSource {
        return ThemeLocalDataSourceImpl(dataStore)
    }
}