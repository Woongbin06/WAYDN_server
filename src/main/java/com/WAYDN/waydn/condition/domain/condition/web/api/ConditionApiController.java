package com.WAYDN.waydn.condition.domain.condition.web.api;

import com.WAYDN.waydn.condition.domain.condition.service.ConditionService;
import com.WAYDN.waydn.condition.domain.condition.web.dto.ConditionCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/condition")
public class ConditionApiController {

    private final ConditionService conditionService;

    @PostMapping("/create")
    public void create(@RequestBody Long id, ConditionCreateRequestDto request) throws Exception {
        conditionService.create(id, request);
    }
}
