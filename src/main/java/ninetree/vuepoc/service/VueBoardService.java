package ninetree.vuepoc.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ninetree.vuepoc.model.VueBoard;
import ninetree.vuepoc.repository.VueBoardJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
}
