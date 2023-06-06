package com.nasa.projectnasa.board.controller;

import com.nasa.projectnasa.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {

  private final BoardService boardService;

}
