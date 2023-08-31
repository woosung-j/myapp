package com.example.myapp.todo.service;

import com.example.myapp.todo.vo.TodoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    Optional<TodoVO> selectTodoByTodoId(int todoId);
    Optional<TodoVO> selectTodoByTodoIdAndUserId(int todoId, int userId);
    List<TodoVO> selectTodosByUserId(int userId);
    List<TodoVO> selectTodosByUserIdAndMonth(int userId, String month);
    List<TodoVO> selectTodosByUserIdAndDay(int userId, String day);
    int insertTodo(TodoVO todoVO);
    int updateTodo(TodoVO todoVO);
    int deleteTodo(int todoId, int userId);
}
