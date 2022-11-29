package com.WAYDN.waydn.condition.domain.user.web.dto;

import com.WAYDN.waydn.condition.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UserJoinRequestDto {

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식이 맞지 않습니다.")
    private String email;

    @NotNull(message = "학번은 필수 입력 값입니다.")
    private int classNumber;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String password;

    @Builder
    public UserJoinRequestDto(String email, int classNumber, String name, String password) {
        this.email = email;
        this.classNumber = classNumber;
        this.name = name;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .classNumber(classNumber)
                .name(name)
                .password(password)
                .build();
    }
}
