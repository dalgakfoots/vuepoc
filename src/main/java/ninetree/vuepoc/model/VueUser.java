package ninetree.vuepoc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VueUser {
    private Long id;
    private String username;
    private String nickname;
}
