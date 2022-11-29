package com.WAYDN.waydn.condition.domain.user.web.api;

import com.WAYDN.waydn.condition.domain.user.service.UserService;
import com.WAYDN.waydn.condition.domain.user.web.dto.UserJoinRequestDto;
import com.WAYDN.waydn.condition.domain.user.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserApiController {

    private final UserService userService;

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.OK)
    public void singUp(@RequestBody @Valid UserJoinRequestDto request) throws Exception {
        userService.signUp(request);
    }

    @GetMapping("/find/{name}")
    public UserResponseDto findByName(@Valid @PathVariable String name) {
        UserResponseDto user = userService.findByName(name);
        return user;
    }

    @GetMapping("/find")
    public List<UserResponseDto> findAll() {
        return userService.findAll();
    }
}
