package com.WAYDN.waydn.condition.domain.user.web.dto;

import com.WAYDN.waydn.condition.domain.condition.web.dto.ConditionResponseDto;
import com.WAYDN.waydn.condition.domain.user.User;
import lombok.Getter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class UserResponseDto {

    private final String name;
    private List<ConditionResponseDto> conditions;

    public UserResponseDto(User user) {
        this.name = user.getName();
        this.conditions = user.getConditions().stream()
                .map(ConditionResponseDto::new)
                .collect(Collectors.toList());
    }
}
