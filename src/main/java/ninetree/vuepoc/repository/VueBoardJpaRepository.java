package ninetree.vuepoc.repository;

import ninetree.vuepoc.model.VueBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueBoardJpaRepository extends JpaRepository<VueBoard , Long> {
}
