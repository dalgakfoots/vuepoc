package ninetree.vuepoc.repository;

import jakarta.transaction.Transactional;
import ninetree.vuepoc.model.VueBoard;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class VueBoardRepositoryTest {

    @Autowired VueBoardRepository vueBoardRepository;

    @Autowired VueBoardJpaRepository jpaRepository;

    @Test
    void save() {
        VueBoard board = new VueBoard(
                1L,
                "Data Fetching",
                "dgfoot",
                "test....",
                LocalDateTime.of(2023, 1, 25, 2, 21),
                LocalDateTime.of(2023, 1, 25, 2, 21)
        );

        VueBoard save = vueBoardRepository.save(board);
        assertThat(board).isEqualTo(save);
    }

    @Test
    void find() {
        VueBoard board = new VueBoard(
                1L,
                "Data Fetching",
                "dgfoot",
                "test....",
                LocalDateTime.of(2023, 1, 25, 2, 21),
                LocalDateTime.of(2023, 1, 25, 2, 21)
        );

        VueBoard save = jpaRepository.save(board);

//        assertThat(board).isEqualTo(save);

        VueBoard vueBoard = jpaRepository.findById(save.getId()).orElseGet(VueBoard::new);

        assertThat(vueBoard).isEqualTo(save);

        jpaRepository.findAll(PageRequest.of(0, 10 , Sort.by("id").descending()));
    }
}