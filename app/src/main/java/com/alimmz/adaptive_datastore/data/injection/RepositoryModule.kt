package com.alimmz.adaptive_datastore.data.injection

import com.alimmz.adaptive_datastore.data.repository.DailyHabitRepositoryImpl
import com.alimmz.adaptive_datastore.data.repository.ThemeRepositoryImpl
import com.alimmz.adaptive_datastore.domain.repository.DailyHabitRepository
import com.alimmz.adaptive_datastore.domain.repository.ThemeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideDailyHabitRepository(
        repository: DailyHabitRepositoryImpl,
    ): DailyHabitRepository

    @Binds
    abstract fun provideThemeRepository(
        repository: ThemeRepositoryImpl,
    ): ThemeRepository

}