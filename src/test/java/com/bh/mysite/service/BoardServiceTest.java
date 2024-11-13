//package com.bh.mysite.service;
//
//import com.bh.mysite.dto.BoardDTO;
//import com.bh.mysite.entity.Board;
//import com.bh.mysite.repository.BoardRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//class BoardServiceTest {
//
//    @Mock
//    private BoardRepository boardRepository;  // BoardRepository를 mock
//
//    @InjectMocks
//    private BoardService boardService;  // BoardService에 mock된 repository 주입
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);  // Mockito 초기화
//    }
//
//    @Test
//    void enrollBoard() {
//        // given
//        BoardDTO boardDTO = BoardDTO.builder()
//                .title("New Post")
//                .body("This is a new post.")
//                .views(10)
//                .postedTime(LocalDateTime.now())
//                .build();
//
//        Board board = Board.builder()
//                .title("New Post")
//                .body("This is a new post.")
//                .views(10)
//                .postedTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))  // 예시로 게시 시간 추가
//                .build();
//
//        // when
//        boardService.enrollBoard(boardDTO);
//
//        // then
//        verify(boardRepository, times(1)).save(board);  // repository의 save() 메서드가 한 번 호출되었는지 확인
//    }
//
//    @Test
//    void getBoardList() {
//        // given
//        Board board1 = Board.builder()
//                .title("First Post")
//                .body("First body")
//                .views(10)
//                .build();
//
//        Board board2 = Board.builder()
//                .title("Second Post")
//                .body("Second body")
//                .views(5)
//                .build();
//
//        List<Board> expectedBoards = Arrays.asList(board1, board2);
//
//        when(boardRepository.findAll()).thenReturn(expectedBoards);  // mock된 findAll()이 expectedBoards를 반환하도록 설정
//
//        // when
//        List<BoardDTO> boards = boardService.getBoardList();
//
//        // then
//        assertNotNull(boards);  // boards가 null이 아니어야 함
//        assertEquals(2, boards.size());  // boards의 크기는 2이어야 함
//        assertEquals("First Post", boards.get(0).getTitle());  // 첫 번째 게시물의 제목이 "First Post"이어야 함
//        assertEquals("Second Post", boards.get(1).getTitle());  // 두 번째 게시물의 제목이 "Second Post"이어야 함
//    }
//}
