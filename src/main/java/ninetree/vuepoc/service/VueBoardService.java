package ninetree.vuepoc.service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ninetree.vuepoc.model.VueBoard;
import ninetree.vuepoc.repository.VueBoardJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class VueBoardService {

    private final VueBoardJpaRepository repository;

    public Page<VueBoard> getVueBoardList(Pageable pageable) {
        Page<VueBoard> page = repository.findAll(pageable);
        return new PageImpl<>(
                page.getContent(),
                pageable,
                page.getTotalElements()
        );
    }

    public Optional<VueBoard> getVueBoard(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public VueBoard insertVueBoard(VueBoard board){
        return repository.save(board);
    }

    @Transactional
    public VueBoard updateVueBoard(VueBoard board) {
        return repository.save(board);
    }

    @Transactional
    public void deleteVueBoard(Long id) {
        repository.deleteById(id);
    }

    @PostConstruct
    @Transactional
    private void makeTestData() {
        log.info("make test data...");
        ArrayList<VueBoard> tempList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            VueBoard temp = new VueBoard(Integer.toUnsignedLong(i),
                    i + "",
                    i + " author",
                    i + " content",
                    LocalDateTime.now(),
                    LocalDateTime.now());

            tempList.add(temp);
        }

        repository.saveAll(tempList);
        log.info("make test data... : done");
    }

}
