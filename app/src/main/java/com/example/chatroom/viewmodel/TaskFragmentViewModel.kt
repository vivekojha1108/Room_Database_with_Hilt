package com.example.chatroom.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.chatroom.model.Task
import com.example.chatroom.room.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskFragmentViewModel @Inject constructor(
    private val taskDao: TaskDao
) : ViewModel() {

    val getAllList: LiveData<List<Task>> = taskDao.getAllTask()

    suspend fun insertData(string: String) {
        taskDao.insertTask(Task(title = string))
    }

}