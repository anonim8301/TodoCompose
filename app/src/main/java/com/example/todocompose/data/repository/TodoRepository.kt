package com.example.todocompose.data.repository

import com.example.todocompose.data.local.TodoDao
import com.example.todocompose.data.models.TodoTask
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped()
class TodoRepository @Inject constructor(
    private val dao: TodoDao,
) {

    fun getAllTasks() = dao.getAllTasks()

    fun getTask(taskId: Int) = dao.getTask(taskId)

    fun searchByQuery(searchQuery: String) = dao.searchByQuery(searchQuery)

    fun sortByLowPriority() = dao.sortByLowPriority()

    fun sortByHighPriority() = dao.sortByHighPriority()

    suspend fun addTask(task: TodoTask) = dao.addTask(task)

    suspend fun updateTask(task: TodoTask) {
        dao.updateTask(task = task)
    }

    suspend fun delete(task: TodoTask) = dao.deleteTask(task)

    suspend fun deleteAllTask() = dao.deleteAllTasks()

}