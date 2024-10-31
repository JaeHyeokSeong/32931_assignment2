package study.demo;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.demo.domain.entity.Member;
import study.demo.domain.entity.Team;
import study.demo.web.service.MemberService;
import study.demo.web.service.TeamService;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final MemberService memberService;
    private final TeamService teamService;

    @PostConstruct
    public void init() {
        //save teams
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        teamService.saveTeam(teamA);
        teamService.saveTeam(teamB);

        //save members
        Member member1 = new Member("member1");
        member1.changeTeam(teamA);
        Member member2 = new Member("member2");
        member2.changeTeam(teamB);
        memberService.saveMember(member1);
        memberService.saveMember(member2);
    }
}
