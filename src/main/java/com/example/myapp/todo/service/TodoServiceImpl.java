package com.example.myapp.todo.service;

import com.example.myapp.todo.mapper.TodoMapper;
import com.example.myapp.todo.vo.TodoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoMapper todoMapper;

    @Autowired
    public TodoServiceImpl(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    @Override
    public Optional<TodoVO> selectTodoByTodoId(int todoId) {
        return todoMapper.selectTodoByTodoId(todoId);
    }

    @Override
    public Optional<TodoVO> selectTodoByTodoIdAndUserId(int todoId, int userId) {
        return todoMapper.selectTodoByTodoIdAndUserId(todoId, userId);
    }

    @Override
    public List<TodoVO> selectTodosByUserId(int userId) {
        return todoMapper.selectTodosByUserId(userId);
    }

    @Override
    public List<TodoVO> selectTodosByUserIdAndMonth(int userId, String month) {
        return todoMapper.selectTodosByUserIdAndMonth(userId, month + "-01");
    }

    @Override
    public List<TodoVO> selectTodosByUserIdAndDay(int userId, String day) {
        return todoMapper.selectTodosByUserIdAndDay(userId, day);
    }

    @Override
    public int insertTodo(TodoVO todoVO) {
        /** TODO: 로그인 구현 후 아래 userId를 변경한다. */
        todoVO.setUserId(1); todoVO.setCreateUser(1); todoVO.setUpdateUser(1);
        
        int todoId = todoMapper.insertTodo(todoVO);

        /** @return (성공: todoId, 실패: 0) */
        if(todoId < 1) return 0;
        return todoVO.getTodoId();
    }

    @Override
    public int updateTodo(TodoVO todoVO) {
        /** TODO: 로그인 구현 후 아래 userId를 변경한다. */
        todoVO.setUserId(1); todoVO.setUpdateUser(1);

        /** @return (성공: 1, 실패: 0) */
        return todoMapper.updateTodo(todoVO);
    }

    @Override
    public int deleteTodo(int todoId, int userId) {
        /** @return (성공: 1, 실패: 0) */
        return todoMapper.deleteTodo(todoId, userId);
    }
}
