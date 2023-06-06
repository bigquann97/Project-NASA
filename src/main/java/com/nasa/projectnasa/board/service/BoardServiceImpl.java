package com.nasa.projectnasa.board.service;

import com.nasa.projectnasa.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl {

  private final BoardRepository boardRepository;

}
