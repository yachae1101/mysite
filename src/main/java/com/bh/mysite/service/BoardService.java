package com.bh.mysite.service;

import com.bh.mysite.dto.BoardDTO;
import com.bh.mysite.entity.Board;
import com.bh.mysite.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    //데이터 저장
    //파라미터를 받아서 엔티티를 생성하고 repository 를 이용해서 삽입
    public void enrollBoard(BoardDTO boardDTO){
        try {
            Date postedTime = Date.from(boardDTO.getPostedTime().atZone(ZoneId.systemDefault()).toInstant());

            //빌더 패턴을 이용한 Entity 생성
            Board board = Board.builder()
                    .title(boardDTO.getTitle())
                    .views(boardDTO.getViews())
                    .body(boardDTO.getBody())
                    .postedTime(postedTime)
                    .build();

            //데이터베이스에 데이터 삽입
            boardRepository.save(board);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // repository 에서 Board 객체를 가져와서 DTO 로 변환 후 전달
    public List<BoardDTO> getBoardList(){
        List<Board> sortedByDateDesc = boardRepository.findAllByOrderByPostedTimeDesc();

        // Board 엔티티를 BoardDTO 로 변환하여 반환
        return sortedByDateDesc.stream()
                .map(board -> BoardDTO.builder()
                        .bid(board.getBid())
                        .title(board.getTitle())
                        .body(board.getBody())
                        .postedTime(board.getPostedTime().toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDateTime())
                        .build())
                .toList();
    }
    //
}
