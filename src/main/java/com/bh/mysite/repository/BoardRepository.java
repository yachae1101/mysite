package com.bh.mysite.repository;

import com.bh.mysite.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository  extends JpaRepository<Board, Long> {
    // postedTime을 기준으로 내림차순 정렬하여 모든 Board 목록 조회
    List<Board> findAllByOrderByPostedTimeDesc();
}