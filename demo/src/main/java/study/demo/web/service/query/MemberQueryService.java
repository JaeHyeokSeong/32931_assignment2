package study.demo.web.service.query;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.demo.domain.entity.Member;
import study.demo.web.repository.MemberRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberQueryService {

    private final MemberRepository memberRepository;

    public MemberDto findMember(Long memberId) {
        Optional<Member> findMember = memberRepository.findById(memberId);
        if (findMember.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return new MemberDto(findMember.get());
    }

    @Data
    static public class MemberDto {
        private Long memberId;
        private String memberName;
        private String teamName;

        public MemberDto(Member member) {
            memberId = member.getId();
            memberName = member.getName();
            teamName = member.getTeam().getName();
        }
    }
}
