package study.demo.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.demo.domain.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
