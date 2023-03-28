package ninetree.vuepoc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ninetree.vuepoc.model.VueBoard;
import org.apache.ibatis.javassist.compiler.ast.Member;
import org.springframework.stereotype.Repository;

@Repository
public class VueBoardRepository {

    @PersistenceContext
    private EntityManager em;

    public VueBoard save(VueBoard board) {
        em.persist(board);
        return board;
    }

    public VueBoard find(Long id) {
        return em.find(VueBoard.class, id);
    }
}
