package com.juanjosesanz.taskmanager.tasks.domain.usecase

import androidx.lifecycle.LiveData
import com.juanjosesanz.taskmanager.tasks.data.repository.TaskRepository
import com.juanjosesanz.taskmanager.tasks.domain.model.Task

class TaskUseCase(private val repository: TaskRepository) {
    fun getAllTasks(): LiveData<MutableList<Task>> {
        return repository.tasks
    }

    suspend fun addTask(task: String) {
        repository.addTask(Task(name= task, description = ""))
    }

    suspend fun taskExists(name: String): Boolean {
        return repository.taskExists(name)
    }

    suspend fun deleteTask(task: Task) {
        repository.deleteTask(task)
    }

    suspend fun updateTask(task: Task) {
        repository.updateTask(task)
    }
}

