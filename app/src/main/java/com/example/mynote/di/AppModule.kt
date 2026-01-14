package com.example.mynote.di

import android.content.Context
import androidx.room.Room
import com.example.mynote.data.NoteDao
import com.example.mynote.data.NoteDatabase
import com.example.mynote.data.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): NoteDatabase =
        Room.databaseBuilder(
            appContext,
            NoteDatabase::class.java,
            "note_db"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideNoteDao(database: NoteDatabase): NoteDao = database.noteDao()

    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository = NoteRepository(noteDao)
}