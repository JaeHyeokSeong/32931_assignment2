package study.demo.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.demo.web.service.query.MemberQueryService;

import static study.demo.web.service.query.MemberQueryService.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberQueryService memberQueryService;

    @GetMapping("/members/{id}")
    public MemberDto findMember(@PathVariable("id") Long id) {
        return memberQueryService.findMember(id);
    }
}
