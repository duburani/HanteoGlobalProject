package com.example.hanteoproject2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.List;

@Component
@RequiredArgsConstructor
public class initDb {
    private final InitService initService;


    @PostConstruct
    public void init(){
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;
        public void dbInit() {
            Board board1 = createBoard("공지사항");
            Board board2 = createBoard("첸");
            Board board3 = createBoard("백현");
            Board board4 = createBoard("시우민");
            Board board5 = createBoard("공지사항");
            Board board6 = createBoard("익명게시판");
            Board board7 = createBoard("뷔");
            Board board8 = createBoard("공지사항");
            Board board9 = createBoard("로제");

            em.persist(board1);
            em.persist(board2);
            em.persist(board3);
            em.persist(board4);
            em.persist(board5);
            em.persist(board6);
            em.persist(board7);
            em.persist(board8);
            em.persist(board9);

            Cate cate1 = createCate("남자", null, null);
            Cate cate2 = createCate("여자", null, null);
            Cate cate3 = createCate("엑소", null, null);
            Cate cate4 = createCate("방탄소년단", cate1, null);
            Cate cate5 = createCate("블랙핑크", cate2, null);

            cate1.addChildCategory(cate3);
            cate1.addChildCategory(cate4);
            cate2.addChildCategory(cate5);

            em.persist(cate1);
            em.persist(cate2);
            em.persist(cate3);
            em.persist(cate4);
            em.persist(cate5);

            CateBoard cateBoard1 = createCateBoard(board1, cate3);
            CateBoard cateBoard2 = createCateBoard(board2, cate3);
            CateBoard cateBoard3 = createCateBoard(board3, cate3);
            CateBoard cateBoard4 = createCateBoard(board4, cate3);
            CateBoard cateBoard5 = createCateBoard(board5, cate4);
            CateBoard cateBoard6 = createCateBoard(board6, cate4);
            CateBoard cateBoard7 = createCateBoard(board7, cate4);
            CateBoard cateBoard8 = createCateBoard(board8, cate5);
            CateBoard cateBoard9 = createCateBoard(board6, cate5);
            CateBoard cateBoard10 = createCateBoard(board9, cate5);

            em.persist(cateBoard1);
            em.persist(cateBoard2);
            em.persist(cateBoard3);
            em.persist(cateBoard4);
            em.persist(cateBoard5);
            em.persist(cateBoard6);
            em.persist(cateBoard7);
            em.persist(cateBoard8);
            em.persist(cateBoard9);
            em.persist(cateBoard10);

        }

        private CateBoard createCateBoard(Board board, Cate cate) {
            CateBoard cateBoard = new CateBoard();
            cateBoard.setCate(cate);
            cateBoard.setBoard(board);
            return cateBoard;
        }

        private Board createBoard(String name) {
            Board board = new Board();
            board.setName(name);
            return board;
        }

        private Cate createCate(String name, Cate parent, List<Cate> children) {
            Cate cate = new Cate();
            cate.setName(name);
            cate.setParent(parent);
            return cate;
        }
    }
}
