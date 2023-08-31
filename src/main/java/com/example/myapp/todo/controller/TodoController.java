package com.example.myapp.todo.controller;

import com.example.myapp.response.*;
import com.example.myapp.todo.service.TodoService;
import com.example.myapp.todo.vo.TodoVO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * todoId에 해당하는 정보를 반환한다.
     * @param todoId
     * @return TodoVO
     */
    @GetMapping("v1/todo/id/{todoId}")
    public ResponseEntity<? extends CommonResponse> getTodoV1(@PathVariable int todoId) {
        /** TODO: 아래 userId(1)은 추후 수정 */
        Optional<TodoVO> todo = todoService.selectTodoByTodoIdAndUserId(todoId, 1);

        if(!todo.isPresent()) // todo에 값이 있는지 검사한다.
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), "해당하는 Todo가 없습니다."));

        return ResponseEntity.ok().body(new SingleResponse<>(todo));
    }

    /**
     * userID에 해당하는 모든 To do 리스트를 반환한다.
     * @param userId
     * @return List<TodoVO>
     */
    @GetMapping("v1/todo/list/{userId}")
    public ResponseEntity<? extends CommonResponse> getTodosByUserIdV1(@PathVariable int userId) {
        List<TodoVO> todos = todoService.selectTodosByUserId(userId);
        return ResponseEntity.ok().body(new ListResponse<>(todos));
    }

    /**
     * 해당 년/월에 해당하는 유저의 To do 리스트를 반환한다.
     * @param month = (yyyy-MM)
     * @param userId
     * @return List<TodoVO>
     */
    @GetMapping("v1/todo/list/month/{month}/{userId}")
    public ResponseEntity<? extends CommonResponse> getTodosByUserIdAndMonthV1(@PathVariable String month, @PathVariable int userId) {
        List<TodoVO> todos = todoService.selectTodosByUserIdAndMonth(userId, month);
        return ResponseEntity.ok().body(new ListResponse<>(todos));
    }

    /**
     * 해당 일에 해당하는 유저의 To do 리스트를 반환한다.
     * @param day = (yyyy-MM-dd)
     * @param userId
     * @return List<TodoVO>
     */
    @GetMapping("v1/todo/list/day/{day}/{userId}")
    public ResponseEntity<? extends CommonResponse> getTodosByUserIdAndDayV1(@PathVariable String day, @PathVariable int userId) {
        List<TodoVO> todos = todoService.selectTodosByUserIdAndDay(userId, day);
        return ResponseEntity.ok().body(new ListResponse<>(todos));
    }

    /**
     * Todo를 추가한다.
     * @param todoVO
     * @return (성공: todoId, 실패: 500 Error)
     */
    @PostMapping("v1/todo")
    public ResponseEntity<? extends CommonResponse> addTodoV1(@Valid @RequestBody TodoVO todoVO) {
        int todoId = todoService.insertTodo(todoVO);

        if(todoId < 1)
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Todo 등록을 실패했습니다."));

        return ResponseEntity.ok().body(new SingleResponse<>("Todo 등록이 완료되었습니다.", todoId));
    }

    /**
     * Todo를 수정한다.
     * @param todoVO
     * @return (성공: 200 OK, 실패: 500 Error)
     */
    @PatchMapping("v1/todo")
    public ResponseEntity<? extends CommonResponse> fixTodoV1(@RequestBody TodoVO todoVO) {
        int cnt = todoService.updateTodo(todoVO);

        if(cnt < 1)
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Todo 수정을 실패했습니다."));

        return ResponseEntity.ok().body(new BasicResponse("Todo 수정이 완료되었습니다."));
    }

    /**
     * Todo를 삭제한다.
     * @param todoId
     * @return (성공: 200 OK, 실패: 500 Error)
     */
    @DeleteMapping("v1/todo/id/{todoId}")
    public ResponseEntity<? extends CommonResponse> delTodoV1(@PathVariable int todoId) {
        /** TODO: 로그인 구현 후 아래 userId를 변경한다. */
        int cnt = todoService.deleteTodo(todoId, 1);

        if(cnt < 1)
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Todo 삭제를 실패했습니다."));

        return ResponseEntity.ok().body(new BasicResponse("Todo 삭제가 완료되었습니다."));
    }
}
