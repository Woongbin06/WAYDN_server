package com.WAYDN.waydn.condition.domain.user.Service;

import com.WAYDN.waydn.condition.domain.user.User;
import com.WAYDN.waydn.condition.domain.user.repository.UserRepository;
import com.WAYDN.waydn.condition.domain.user.web.dto.UserJoinRequestDto;
import com.WAYDN.waydn.condition.domain.user.web.dto.UserLoginRequestDto;
import com.WAYDN.waydn.condition.domain.user.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto signUp(UserJoinRequestDto request) {
        User user = userRepository.save(request.toEntity());
        return new UserResponseDto(user);
    }

    public Optional<User> login(UserLoginRequestDto request) throws Exception {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new Exception()));

        return user;
    }

    public Optional<User> findByName(String name) {
        Optional<User> findUser = userRepository.findByName(name);
        return findUser;
    }

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
