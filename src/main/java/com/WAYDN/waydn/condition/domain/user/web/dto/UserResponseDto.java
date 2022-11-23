package com.WAYDN.waydn.condition.domain.user.web.dto;

import com.WAYDN.waydn.condition.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long id;
    private String name;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
