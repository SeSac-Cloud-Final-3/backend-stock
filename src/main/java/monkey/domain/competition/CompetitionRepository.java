package monkey.domain.competition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    @Query("SELECT c.active FROM Competition c WHERE id = ?1")
    boolean isActive(Long competitionId);

    @Query(nativeQuery = true, value = "SELECT id FROM Competition WHERE start = CURDATE()")
    List<Long> findCompetitionStartsToday();

    @Query(nativeQuery = true, value = "SELECT id FROM Competition WHERE end = CURDATE()")
    List<Long> findCompetitionEndsToday();
}
