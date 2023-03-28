package ninetree.vuepoc.service;

import lombok.RequiredArgsConstructor;
import ninetree.vuepoc.model.VueBoard;
import ninetree.vuepoc.repository.VueBoardJpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VueBoardService {

    private final VueBoardJpaRepository repository;

    public List<VueBoard> getVueBoardList() {
        return repository.findAll();
    }

    public Optional<VueBoard> getVueBoard(Long id) {
        return repository.findById(id);
    }
}
