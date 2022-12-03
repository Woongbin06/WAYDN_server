package com.WAYDN.waydn.condition.domain.condition.web.api;

import com.WAYDN.waydn.condition.domain.condition.service.ConditionService;
import com.WAYDN.waydn.condition.domain.condition.web.dto.ConditionCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/condition")
public class ConditionApiController {

    private final ConditionService conditionService;

    @PostMapping("/create/{id}")
    public void create(@PathVariable Long id, @RequestBody ConditionCreateRequestDto request) throws Exception {
        conditionService.create(id, request);
    }

    @PostMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid ConditionCreateRequestDto request) throws Exception {
        conditionService.update(id, request);
    }

    @DeleteMapping("/delete/{userId}/{conditionId}")
    public void delete(@PathVariable Long userId, @PathVariable Long conditionId) throws Exception {
        conditionService.delete(userId, conditionId);
    }
}
