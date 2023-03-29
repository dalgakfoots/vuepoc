package ninetree.vuepoc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ninetree.vuepoc.model.VueBoard;
import ninetree.vuepoc.service.VueBoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class VueBoardController {

    private final VueBoardService vueBoardService;

    @GetMapping("/list")
    public ResponseEntity<List<VueBoard>> getList() {
        log.info("fetching......");
        List<VueBoard> result = vueBoardService.getVueBoardList();
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<VueBoard> getBoard(@PathVariable Long id){
        log.info("fetching...... id : " + id);
        Optional<VueBoard> vueBoard = vueBoardService.getVueBoard(id);
        VueBoard result = vueBoard.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @PostMapping("/list/new")
    public ResponseEntity<VueBoard> postNewBoard(@RequestBody VueBoard board){
        log.info("BOARD : "+ board);
        board.setRegDate(LocalDateTime.now());
        board.setUpDate(LocalDateTime.now());
        VueBoard result = vueBoardService.insertVueBoard(board);
        return new ResponseEntity<>( result, HttpStatus.OK );
    }

    @PutMapping("/list/update")
    public ResponseEntity<VueBoard> putBoard(@RequestBody VueBoard board) {
        log.info("UPDATE : " + board);
        board.setUpDate(LocalDateTime.now());
        VueBoard result = vueBoardService.updateVueBoard(board);
        log.info("UPDATED : "+ result);
        return new ResponseEntity<>( result, HttpStatus.OK );
    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity deleteBoard(@PathVariable Long id){
        log.info("DELETE id : "+id);
        vueBoardService.deleteVueBoard(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
