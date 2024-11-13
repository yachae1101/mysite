package com.bh.mysite.controller;

import com.bh.mysite.dto.BoardDTO;
import com.bh.mysite.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/board")
    public String saveBook(@RequestBody BoardDTO boardDTO) {
        boardService.enrollBoard(boardDTO);
        return "enrolled";
    }

    @GetMapping("/board")
    public ResponseEntity<List<BoardDTO>> getBoard(){
        try {
            List<BoardDTO> boardList =  boardService.getBoardList();
            return ResponseEntity.status(HttpStatus.OK).body(boardList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}