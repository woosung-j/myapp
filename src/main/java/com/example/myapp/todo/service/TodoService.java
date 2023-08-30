package com.example.myapp.todo.service;

import com.example.myapp.todo.vo.TodoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    Optional<TodoVO> selectTodoByTodoId(int todoId);
    List<TodoVO> selectTodosByUserId(int userId);
    int insertTodo(TodoVO todoVO);
    int updateTodo(TodoVO todoVO);
    int deleteTodo(@Param("todoId") int todoId,
                   @Param("userId") int userId);
}
