package ninetree.vuepoc.controller;

import ninetree.vuepoc.model.VueUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class VueUserController {

    @GetMapping("/user")
    public ResponseEntity<VueUser> getUser () {
        VueUser vueUser = new VueUser(1L, "seungwooHam", "dgfoot");
        return new ResponseEntity<>(vueUser , HttpStatus.OK);
    }
}
