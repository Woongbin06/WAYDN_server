package com.WAYDN.waydn.condition.domain.user.web.dto;

import com.WAYDN.waydn.condition.domain.condition.Condition;
import com.WAYDN.waydn.condition.domain.user.User;
import lombok.Getter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class UserResponseDto {

    private Long id;
    private String name;
    private List<Condition> conditions;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public UserResponseDto(Optional<User> user) {
        this.id = user.get().getId();
        this.name = user.get().getName();
    }
}
