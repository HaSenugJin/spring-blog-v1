package shop.mtcoding.blog.board;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.user.User;


import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "board_tb") // 테이블 이름
public class Board {

    @Id //JavaX 프라이머리키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 오토인크리먼트
    private int id;
    private String title;
    private String content;

    @ManyToOne
    private User user;

    @CreationTimestamp
    private LocalDateTime created_at;
}