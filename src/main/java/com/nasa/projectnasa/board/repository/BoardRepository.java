package com.nasa.projectnasa.board.repository;

import com.nasa.projectnasa.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
