package com.example.chatroom.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.chatroom.model.Task
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    class CallBack @Inject constructor(
        private val database: Provider<TaskDatabase>
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            GlobalScope.launch {
                database.get().taskDao().insertTask(Task(0, "Hello"))
                database.get().taskDao().insertTask(Task(1, "Hello1"))
                database.get().taskDao().insertTask(Task(2, "Hello2"))
                database.get().taskDao().insertTask(Task(3, "Hello3"))
            }
        }
    }

    companion object {
        private const val TAG = "TaskDatabase"
    }

}