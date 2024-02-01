package shop.mtcoding.blog.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardRepository {
    private final EntityManager em;

    public List<Board> findAll(int page) {

        int value = page * 3;

        // 내림차순 해줘야 보기좋음
        Query query = em.createNativeQuery
                ("select * from board_tb order by id desc limit ?,3", Board.class);

        query.setParameter(1, value);


        List<Board> boardList = query.getResultList();
        return boardList;
    }
}
