package ninetree.vuepoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOARD")
public class VueBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOARD_ID")
    private Long id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime upDate;
}
