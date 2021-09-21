package com.example.chatroom.di

import android.app.Application
import androidx.room.Room
import com.example.chatroom.room.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideTaskDatabase(
        app: Application,
        callback: TaskDatabase.CallBack
    ) = Room.databaseBuilder(app, TaskDatabase::class.java, "task_db")
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()

    @Provides
    fun provideTaskDao(db: TaskDatabase) = db.taskDao()

}