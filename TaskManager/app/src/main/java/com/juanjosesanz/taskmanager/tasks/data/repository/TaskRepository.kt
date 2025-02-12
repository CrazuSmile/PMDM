package com.juanjosesanz.taskmanager.tasks.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.juanjosesanz.taskmanager.tasks.data.local.dao.TaskDAO
import com.juanjosesanz.taskmanager.tasks.data.local.entities.TaskEntity
import com.juanjosesanz.taskmanager.tasks.domain.model.Task

class TaskRepository(private val taskDAO: TaskDAO) {
    val tasks: LiveData<MutableList<Task>> = taskDAO.getAllTasks().map { items ->
        items.map { taskEntity ->
            Task(
                id = taskEntity.id,
                name = taskEntity.name,
                isDone = taskEntity.isDone,
                description = taskEntity.description
            )
        }.toMutableList()
    }

    suspend fun taskExists(name: String): Boolean = taskDAO.taskExists(name)

    suspend fun addTask(task: Task) {
        taskDAO.addTask(TaskEntity(name = task.name))
    }

    suspend fun deleteTask(task: Task) =
        taskDAO.deleteTask(TaskEntity(id = task.id, name = task.name))

    suspend fun updateTask(task: Task) = taskDAO.updateTask(
        TaskEntity(
            id = task.id,
            name = task.name,
            isDone = task.isDone,
            description = task.description
        )
    )

    suspend fun getTaskById(taskId: Int): Task {
        val taskEntity = taskDAO.getTaskById(taskId)
        return taskEntity.let {
            Task(
                id = it.id,
                name = it.name,
                isDone = it.isDone,
                description = it.description
            )
        }
    }
}

