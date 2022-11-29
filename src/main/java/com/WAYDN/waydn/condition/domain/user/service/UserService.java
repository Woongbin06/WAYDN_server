package com.WAYDN.waydn.condition.domain.user.service;

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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long signUp(UserJoinRequestDto request) throws Exception {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new Exception("이미 존재하는 이메일입니다.");
        }
        User user = userRepository.save(request.toEntity());

        return user.getId();
    }

    public UserResponseDto login(UserLoginRequestDto request) throws Exception {
        User result;
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new Exception("존재하지 않는 회원입니다."));

        if (user.getPassword().equals(request.getPassword())) {
            result = request.toEntity();
        } else {
            throw new Exception("잘못된 비밀번호입니다.");
        }

        return new UserResponseDto(result);
    }

    public UserResponseDto findByName(String name) {
        Optional<User> user = userRepository.findByName(name);
        return new UserResponseDto(user);
    }

    public List<UserResponseDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }
}
