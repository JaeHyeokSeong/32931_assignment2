package study.demo.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.demo.domain.entity.Team;
import study.demo.web.repository.TeamRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class TeamService {

    private final TeamRepository teamRepository;

    public Long saveTeam(Team team) {
        Team savedTeam = teamRepository.save(team);
        return savedTeam.getId();
    }
}
