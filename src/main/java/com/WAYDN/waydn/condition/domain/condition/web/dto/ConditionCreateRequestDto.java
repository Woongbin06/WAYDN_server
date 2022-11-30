package com.WAYDN.waydn.condition.domain.condition.web.dto;

import com.WAYDN.waydn.condition.domain.condition.Condition;
import com.WAYDN.waydn.condition.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class ConditionCreateRequestDto {

    @NotBlank(message = "상태를 입력해주세요.")
    private String content;

    public ConditionCreateRequestDto(String content) {
        this.content = content;
    }

    public Condition toEntity() {
        return Condition.builder()
                .content(content)
                .build();
    }
}
