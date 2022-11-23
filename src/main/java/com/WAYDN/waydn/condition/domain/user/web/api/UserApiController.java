package com.WAYDN.waydn.condition.domain.user.web.api;

import com.WAYDN.waydn.condition.domain.user.Service.UserService;
import com.WAYDN.waydn.condition.domain.user.User;
import com.WAYDN.waydn.condition.domain.user.web.dto.UserJoinRequestDto;
import com.WAYDN.waydn.condition.domain.user.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserApiController {

    private final UserService userService;

    @PostMapping("/join")
    public UserResponseDto singUp(@RequestBody @Valid UserJoinRequestDto request) {
        return userService.signUp(request);
    }

    @GetMapping("/find/name")
    public Optional<User> findByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    @GetMapping("/find")
    public List<User> findAll() {
        return userService.findAll();
    }
}
