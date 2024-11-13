package com.bh.mysite.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@Getter
@Builder
public class BoardDTO {
    private long bid;
    private LocalDateTime postedTime;
    private String title;
    private String body;
    private int views;
}