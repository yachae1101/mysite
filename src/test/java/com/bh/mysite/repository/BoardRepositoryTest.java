//package com.bh.mysite.repository;
//
//import com.bh.mysite.entity.Board;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.util.Date;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//class BoardRepositoryTest {
//
//    @Autowired
//    private BoardRepository boardRepository;
//
//    @Test
//    void findAllByOrderByPostedTimeDesc() {
//        // Given: 테스트 데이터를 저장
//        Board board1 = Board.builder()
//                .title("First Post")
//                .body("This is the first post.")
//                .views(10)
//                .postedTime(Date.from(LocalDateTime.now().minusDays(1).atZone(ZoneId.systemDefault()).toInstant()))
//                .build();
//        boardRepository.save(board1);
//
//        Board board2 = Board.builder()
//                .title("Second Post")
//                .body("This is the second post.")
//                .views(5)
//                .postedTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
//                .build();
//        boardRepository.save(board2);
//
//        Board board3 = Board.builder()
//                .title("Third Post")
//                .body("This is the third post.")
//                .views(20)
//                .postedTime(Date.from(LocalDateTime.now().minusDays(2).atZone(ZoneId.systemDefault()).toInstant()))
//                .build();
//        boardRepository.save(board3);
//
//        // When: findAllByOrderByPostedTimeDesc() 호출
//        List<Board> result = boardRepository.findAllByOrderByPostedTimeDesc();
//
//        // Then: 결과가 내림차순으로 정렬되었는지 확인
//        assertThat(result).hasSize(3);
//        assertThat(result.get(0).getTitle()).isEqualTo("Second Post");
//        assertThat(result.get(1).getTitle()).isEqualTo("First Post");
//        assertThat(result.get(2).getTitle()).isEqualTo("Third Post");
//    }
//}
