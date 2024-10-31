package study.demo.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.demo.domain.entity.Member;
import study.demo.web.repository.MemberRepository;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Long saveMember(Member member) {
        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }
}
