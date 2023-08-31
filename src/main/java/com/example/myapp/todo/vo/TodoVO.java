package com.example.myapp.todo.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TodoVO {
    private int todoId;
    private int userId;

    @NotNull(message = "{valid.todoTitle.notNull}")
    private String todoTitle;

    @NotNull(message = "{valid.todoContent.notNull}")
    private String todoContent;

    @NotNull(message = "{valid.startDate.notNull}")
    private String startDate;

    @NotNull(message = "{valid.endDate.notNull}")
    private String endDate;

    private boolean todoDone;
    private String createDate;
    private int createUser;
    private String updateDate;
    private int updateUser;
}
