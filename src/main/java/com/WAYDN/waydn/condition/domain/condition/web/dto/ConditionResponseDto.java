package com.WAYDN.waydn.condition.domain.condition.web.dto;

import com.WAYDN.waydn.condition.domain.condition.Condition;
import lombok.Getter;

@Getter
public class ConditionResponseDto {

    private final String content;

    public ConditionResponseDto(Condition condition) {
        this.content = condition.getContent();
    }
}
