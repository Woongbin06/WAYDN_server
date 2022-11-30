package com.WAYDN.waydn.condition.domain.condition.service;

import com.WAYDN.waydn.condition.domain.condition.Condition;
import com.WAYDN.waydn.condition.domain.condition.repository.ConditionRepository;
import com.WAYDN.waydn.condition.domain.condition.web.dto.ConditionCreateRequestDto;
import com.WAYDN.waydn.condition.domain.user.User;
import com.WAYDN.waydn.condition.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ConditionService {

    private final ConditionRepository conditionRepository;
    private final UserRepository userRepository;

    @Transactional
    public void create(Long userId, ConditionCreateRequestDto request) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("로그인 후 이용 가능합니다."));
        Condition condition = conditionRepository.save(request.toEntity());
        condition.confirmWriter(user);
    }

    @Transactional
    public void delete(Long userId, Long conditionId) throws Exception {
        Condition condition = conditionRepository.findById(conditionId)
                .orElseThrow(() -> new Exception("로그인 후 이용 가능합니다."));

        Optional<User> user = userRepository.findById(conditionId);
        if (!condition.getWriter().getEmail().equals(user.get().getEmail())) {
            throw new Exception("본인의 상태가 아닙니다.");
        }

        conditionRepository.delete(condition);
    }

    @Transactional
    public void update(Long id, ConditionCreateRequestDto request) {
        Optional<Condition> condition = conditionRepository.findById(id);

        condition.get().update(request.getContent());
    }
}
