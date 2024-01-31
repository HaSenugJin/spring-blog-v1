package shop.mtcoding.blog.user;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_tb") // 테이블 이름
public class User {

    @Id //JavaX 프라이머리키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 오토인크리먼트
    private int id;

    // 유니크로 만듬
    @Column(unique = true)
    private String username;

    // 60자 못넘고 null이면 안됨
    @Column(length = 60, nullable = false)
    private String password;
    private String email;

    @CreationTimestamp
    private LocalDateTime createdAt;
}