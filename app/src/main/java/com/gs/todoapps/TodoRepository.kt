package com.gs.todoapps

class TodoRepository(
    private val todoDao: TodoDao,
    private val apiService: ApiService
) {

    // Fetch from API and update local cache
    suspend fun refreshTodos() {
        val todosFromApi = apiService.getTodos()
        todoDao.clearTodos()
        todoDao.insertTodos(todosFromApi)
    }

    // Get todos from local database
    suspend fun getTodos(): List<Todo> {
        return todoDao.getAllTodos()
    }
}
